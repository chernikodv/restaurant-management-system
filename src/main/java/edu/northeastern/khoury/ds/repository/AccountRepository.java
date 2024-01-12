package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    @EntityGraph(attributePaths = { "creditCards" })
    Optional<Account> findByUsername(String username);
}
