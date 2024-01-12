package edu.northeastern.khoury.ds.controller;

import edu.northeastern.khoury.ds.domain.dto.account.SignUpRequest;
import edu.northeastern.khoury.ds.domain.dto.account.SignUpResponse;
import edu.northeastern.khoury.ds.domain.dto.account.SignInResponse;
import edu.northeastern.khoury.ds.domain.dto.account.SignInRequest;
import edu.northeastern.khoury.ds.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping(path = "/sign-in")
    public SignInResponse signIn(@RequestBody SignInRequest request) {
        return accountService.signIn(request);
    }

    @PostMapping(path = "/sign-up")
    public SignUpResponse signUp(@RequestBody SignUpRequest request) {
        return accountService.signUp(request);
    }
}
