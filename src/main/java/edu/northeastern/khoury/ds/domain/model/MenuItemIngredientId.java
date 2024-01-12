package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Embeddable
@NoArgsConstructor
public class MenuItemIngredientId implements Serializable {

    @Serial
    private static final long serialVersionUID = -1737433629710641964L;

    private Integer menuItemId;
    private Integer ingredientId;
}
