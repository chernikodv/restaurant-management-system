package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.Payment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    @Override
    @EntityGraph(attributePaths = { "creditCard" })
    List<Payment> findAll();
}
