package edu.northeastern.khoury.ds.domain.dto;

public record PaymentResponse(String total, String confirmationId, String creditCardNumber) {
}
