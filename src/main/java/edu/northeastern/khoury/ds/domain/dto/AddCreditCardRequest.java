package edu.northeastern.khoury.ds.domain.dto;

public record AddCreditCardRequest (String number,
                                    String holder,
                                    Integer expirationYear,
                                    Integer expirationMonth) {
}
