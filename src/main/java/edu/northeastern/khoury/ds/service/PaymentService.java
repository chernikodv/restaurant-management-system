package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.model.CreditCard;
import edu.northeastern.khoury.ds.domain.model.Payment;
import edu.northeastern.khoury.ds.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CreditCardService creditCardService;

    public Payment pay(Integer creditCardId, BigDecimal total) {
        final CreditCard creditCard = creditCardService.findById(creditCardId);

        final Payment payment = new Payment();
        payment.setId(UUID.randomUUID().toString().replace("-", ""));
        payment.setHappenedAt(LocalDateTime.now());
        payment.setCreditCard(creditCard);
        payment.setTotal(total);

        return paymentRepository.save(payment);
    }
}
