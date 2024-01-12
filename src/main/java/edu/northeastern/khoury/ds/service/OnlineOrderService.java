package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.dto.CreateOnlineOrderRequest;
import edu.northeastern.khoury.ds.domain.dto.EmployeeResponse;
import edu.northeastern.khoury.ds.domain.dto.MenuItemQuantity;
import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.dto.OnlineOrderResponse;
import edu.northeastern.khoury.ds.domain.dto.PaymentResponse;
import edu.northeastern.khoury.ds.domain.dto.payment.PaymentDetails;
import edu.northeastern.khoury.ds.domain.model.Account;
import edu.northeastern.khoury.ds.domain.model.Employee;
import edu.northeastern.khoury.ds.domain.model.EmployeeSchedule;
import edu.northeastern.khoury.ds.domain.model.MenuItem;
import edu.northeastern.khoury.ds.domain.model.MenuItemNameQuantity;
import edu.northeastern.khoury.ds.domain.model.OnlineOrder;
import edu.northeastern.khoury.ds.domain.model.OnlineOrderInfo;
import edu.northeastern.khoury.ds.domain.model.OnlineOrderInfoId;
import edu.northeastern.khoury.ds.domain.model.Payment;
import edu.northeastern.khoury.ds.exception.ResourceNotFoundException;
import edu.northeastern.khoury.ds.mapper.EmployeeMapper;
import edu.northeastern.khoury.ds.mapper.PaymentMapper;
import edu.northeastern.khoury.ds.repository.EmployeeScheduleRepository;
import edu.northeastern.khoury.ds.repository.OnlineOrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OnlineOrderService {

    private final Random random;
    private final AccountService accountService;

    private final PaymentMapper paymentMapper;
    private final PaymentService paymentService;

    private final MenuItemService menuItemService;
    private final OnlineOrderRepository onlineOrderRepository;
    private final OnlineOrderInfoService onlineOrderInfoService;
    private final AccessTokenInfoExtractor accessTokenInfoExtractor;

    private final EmployeeMapper employeeMapper;
    private final EmployeeScheduleRepository employeeScheduleRepository;

    public OnlineOrderResponse create(CreateOnlineOrderRequest request) {
        final String username = accessTokenInfoExtractor.getUsername();
        final Account account = accountService.findByUsername(username);

        final LocalDateTime current = LocalDateTime.now();
        final List<EmployeeSchedule> schedule = employeeScheduleRepository.findAvailable(
                current.getDayOfWeek().getValue(), current.toLocalTime()
        );

        final Employee employee = schedule.get(random.nextInt(schedule.size())).getEmployee();

        final OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.setCreatedAt(LocalDateTime.now());
        onlineOrder.setTip(request.tip());
        onlineOrder.setEmployee(employee);
        onlineOrder.setAccount(account);

        final OnlineOrder savedOnlineOrder = onlineOrderRepository.save(onlineOrder);

        final List<OnlineOrderInfo> orderDetails = new LinkedList<>();
        for (MenuItemQuantity menuItemQuantity: request.onlineOrderInfo()) {
            final int menuItemId = menuItemQuantity.menuItemId();
            final MenuItem menuItem = menuItemService.findById(menuItemId);

            final OnlineOrderInfoId orderInfoId = new OnlineOrderInfoId();
            orderInfoId.setOnlineOrderId(savedOnlineOrder.getId());
            orderInfoId.setMenuItemId(menuItemId);

            final OnlineOrderInfo orderInfo = new OnlineOrderInfo();
            orderInfo.setQuantity(menuItemQuantity.quantity());
            orderInfo.setOnlineOrder(savedOnlineOrder);
            orderInfo.setMenuItem(menuItem);
            orderInfo.setId(orderInfoId);

            orderDetails.add(orderInfo);
        }

        final List<OnlineOrderInfo> savedOrderDetails = onlineOrderInfoService.save(orderDetails);

        final BigDecimal price = onlineOrderRepository.findPrice(savedOnlineOrder.getId());
        final Payment payment = paymentService.pay(request.creditCardId(), price.add(request.tip()));
        savedOnlineOrder.setPayment(payment);

        final OnlineOrder updatedOnlineOrder = onlineOrderRepository.save(savedOnlineOrder);

        final EmployeeResponse employeeResponse = employeeMapper.mapToResponse(updatedOnlineOrder.getEmployee());
        final PaymentResponse paymentResponse = paymentMapper.mapToResponse(updatedOnlineOrder.getPayment());
        final List<MenuItemNameQuantity> items = savedOrderDetails.stream().map(orderInfo -> {
            final String name = orderInfo.getMenuItem().getName();
            final int quantity = orderInfo.getQuantity();
            return new MenuItemNameQuantity(name, quantity);
        }).toList();

        return new OnlineOrderResponse(updatedOnlineOrder.getId(), paymentResponse, employeeResponse, items);
    }

    public PaymentDetails findPaymentDetails(Integer id) {
        final String username = accessTokenInfoExtractor.getUsername();
        final BigDecimal total = onlineOrderRepository.findByIdAndUsernameLoadPayment(id, username)
                .orElseThrow(ResourceNotFoundException::new)
                .getPayment().getTotal();
        final BigDecimal price = onlineOrderRepository.findPrice(id);
        return new PaymentDetails(price, total.subtract(price), total);
    }

    public List<OnlineOrderResponse> findAll() {
        final String username = accessTokenInfoExtractor.getUsername();
        final List<OnlineOrder> orders = onlineOrderRepository.findAllByUsername(username);

        return orders.stream().map(onlineOrder -> {
            final EmployeeResponse employeeResponse = employeeMapper.mapToResponse(onlineOrder.getEmployee());
            final PaymentResponse paymentResponse = paymentMapper.mapToResponse(onlineOrder.getPayment());
            final List<MenuItemNameQuantity> items = onlineOrder.getOnlineOrderInfo().stream()
                    .map(orderInfo -> {
                        final String name = orderInfo.getMenuItem().getName();
                        final int quantity = orderInfo.getQuantity();
                        return new MenuItemNameQuantity(name, quantity);
                    }).toList();
            return new OnlineOrderResponse(onlineOrder.getId(), paymentResponse, employeeResponse, items);
        }).toList();
    }

    @Transactional
    public NutritionFacts computeNutritionFacts(Integer id) {
        return onlineOrderRepository.computeNutritionFacts(id);
    }
}
