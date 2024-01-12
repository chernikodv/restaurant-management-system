package edu.northeastern.khoury.ds.domain.view;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Embeddable
@NoArgsConstructor
public class CreditCardStatisticsId implements Serializable {

    @Serial
    private static final long serialVersionUID = 8205642140258065844L;

    private Integer creditCardId;
    private String username;
}
