package edu.northeastern.khoury.ds.repository.view;

import edu.northeastern.khoury.ds.domain.view.CreditCardStatistics;
import edu.northeastern.khoury.ds.domain.view.CreditCardStatisticsId;

import java.util.List;

public interface CreditCardStatisticsRepository extends ReadOnlyRepository<CreditCardStatistics, CreditCardStatisticsId> {
    List<CreditCardStatistics> findById_Username(String username);

    default List<CreditCardStatistics> findByUsername(String username) {
        return findById_Username(username);
    }
}
