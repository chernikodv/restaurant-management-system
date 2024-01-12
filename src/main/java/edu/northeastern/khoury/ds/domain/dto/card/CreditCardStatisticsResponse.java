package edu.northeastern.khoury.ds.domain.dto.card;

import java.math.BigDecimal;

public record CreditCardStatisticsResponse(String holder, String number, String expiration, String total) {
}
