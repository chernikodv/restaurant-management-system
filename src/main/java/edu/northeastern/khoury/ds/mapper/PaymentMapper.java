package edu.northeastern.khoury.ds.mapper;

import edu.northeastern.khoury.ds.domain.dto.PaymentResponse;
import edu.northeastern.khoury.ds.domain.model.Payment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentMapper {

    public PaymentResponse mapToResponse(Payment payment) {
        // 1234432160199910
        final String total = payment.getTotal() + "$";
        final String confirmationId = payment.getId();
        final String number = "*".repeat(4) + " " + payment.getCreditCard().getNumber().substring(12);
        return new PaymentResponse(total, confirmationId, number);
    }
}
