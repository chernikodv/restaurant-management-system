package edu.northeastern.khoury.ds.mapper;

import edu.northeastern.khoury.ds.domain.dto.account.SignUpRequest;
import edu.northeastern.khoury.ds.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer mapToEntity(SignUpRequest request) {
        final Customer customer = new Customer();
        customer.setPhoneNumber(request.phoneNumber());
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());

        return customer;
    }
}
