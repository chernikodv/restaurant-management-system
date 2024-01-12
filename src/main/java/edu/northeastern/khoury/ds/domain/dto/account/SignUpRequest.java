package edu.northeastern.khoury.ds.domain.dto.account;

public record SignUpRequest(String phoneNumber,
                            String firstName,
                            String lastName,
                            String username,
                            String password,
                            String email) {
}
