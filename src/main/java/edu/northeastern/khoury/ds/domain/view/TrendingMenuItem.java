package edu.northeastern.khoury.ds.domain.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Data
@Entity
@Immutable
public class TrendingMenuItem {

    @Id
    private Integer id;

    private String name;
    private String price;
    private Integer numberOfLikes;
}
