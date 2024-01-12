package edu.northeastern.khoury.ds.domain.dto.payment;

import java.math.BigDecimal;

public record PaymentDetails(BigDecimal price, BigDecimal tip, BigDecimal total) {
}
