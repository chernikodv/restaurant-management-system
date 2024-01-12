package edu.northeastern.khoury.ds.domain.dto.account;

import lombok.Builder;

@Builder
public record SignUpResponse(String phoneNumber,
                             String username,
                             String email) {
}
