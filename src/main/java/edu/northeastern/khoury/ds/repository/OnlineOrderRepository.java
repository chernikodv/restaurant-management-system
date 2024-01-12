package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.model.OnlineOrder;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OnlineOrderRepository extends JpaRepository<OnlineOrder, Integer> {
    @Query(value = "SELECT online_order_total_price_v2(:id);", nativeQuery = true)
    BigDecimal findPrice(@Param("id") Integer id);

    @EntityGraph(attributePaths = { "payment", "account" })
    Optional<OnlineOrder> findByIdAndAccount_Username(Integer id, String username);

    @EntityGraph(attributePaths = { "payment", "employee" })
    List<OnlineOrder> findAllByAccount_Username(String username);

    @Procedure(name = "order_nutrition_facts")
    NutritionFacts computeNutritionFacts(@Param("online_order_id") Integer onlineOrderId);

    default Optional<OnlineOrder> findByIdAndUsernameLoadPayment(Integer id, String username) {
        return findByIdAndAccount_Username(id, username);
    }

    default List<OnlineOrder> findAllByUsername(String username) {
        return findAllByAccount_Username(username);
    }
}
