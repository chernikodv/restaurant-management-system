package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT employee_tips_for_last_30_days(:id);", nativeQuery = true)
    BigDecimal findTipsForLast30Days(@Param("id") Integer id);
}
