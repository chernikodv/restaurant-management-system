package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer fatPerServingSize;
    private Integer proteinPerServingSize;
    private Integer caloriesPerServingSize;
    private Integer carbohydratePerServingSize;
}
