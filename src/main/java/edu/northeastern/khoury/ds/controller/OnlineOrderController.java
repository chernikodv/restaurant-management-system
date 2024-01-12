package edu.northeastern.khoury.ds.controller;

import edu.northeastern.khoury.ds.domain.dto.CreateOnlineOrderRequest;
import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.dto.OnlineOrderResponse;
import edu.northeastern.khoury.ds.domain.dto.payment.PaymentDetails;
import edu.northeastern.khoury.ds.service.OnlineOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/online-orders")
public class OnlineOrderController {

    private final OnlineOrderService onlineOrderService;

    @PostMapping
    public OnlineOrderResponse create(@RequestBody CreateOnlineOrderRequest request) {
        return onlineOrderService.create(request);
    }

    @GetMapping
    public List<OnlineOrderResponse> findAll() {
        return onlineOrderService.findAll();
    }

    @GetMapping(path = "/{id}/nutrition-facts")
    public NutritionFacts computeNutritionFacts(@PathVariable Integer id) {
        return onlineOrderService.computeNutritionFacts(id);
    }

    @GetMapping(path = "/{id}/payment-details")
    public PaymentDetails findPaymentDetails(@PathVariable Integer id) {
        return onlineOrderService.findPaymentDetails(id);
    }
}
