package edu.northeastern.khoury.ds.domain.view;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
public class CreditCardStatistics {

    @EmbeddedId
    private CreditCardStatisticsId id;

    private String total;
    private String holder;
    private String number;
    private String expiration;
}
