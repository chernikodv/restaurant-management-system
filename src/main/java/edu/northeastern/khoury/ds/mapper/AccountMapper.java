package edu.northeastern.khoury.ds.mapper;

import edu.northeastern.khoury.ds.domain.dto.account.SignUpRequest;
import edu.northeastern.khoury.ds.domain.dto.account.SignUpResponse;
import edu.northeastern.khoury.ds.domain.model.Account;
import edu.northeastern.khoury.ds.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountMapper {
    
    private final CustomerMapper customerMapper;

    public Account mapToEntity(SignUpRequest request) {
        final Customer customer = customerMapper.mapToEntity(request);
        
        final Account account = new Account();
        account.setUsername(request.username());
        account.setPassword(request.password());
        account.setEmail(request.email());
        account.setCustomer(customer);
        
        return account;
    }

    public SignUpResponse mapToResponse(Account savedAccount) {
        return SignUpResponse.builder()
                .phoneNumber(savedAccount.getCustomer().getPhoneNumber())
                .username(savedAccount.getUsername())
                .email(savedAccount.getEmail())
                .build();
    }
}
