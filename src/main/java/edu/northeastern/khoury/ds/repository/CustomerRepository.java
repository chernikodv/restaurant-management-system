package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
