package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    Optional<CreditCard> findByNumber(String number);

    @Query(value = "SELECT count_saved_credit_card_by_id(:id);", nativeQuery = true)
    int countSavedCreditCards(@Param("id") Integer id);
}
