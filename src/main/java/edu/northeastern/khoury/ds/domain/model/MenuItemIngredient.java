package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "menu_item_ingredient")
public class MenuItemIngredient {

    @EmbeddedId
    private MenuItemIngredientId id;

    @ToString.Exclude
    @MapsId(value = "menuItemId")
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

    @ToString.Exclude
    @MapsId(value = "ingredientId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    private Integer servingSize;
}
