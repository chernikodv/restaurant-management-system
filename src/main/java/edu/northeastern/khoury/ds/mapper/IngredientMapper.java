package edu.northeastern.khoury.ds.mapper;

import edu.northeastern.khoury.ds.domain.dto.IngredientServingSize;
import edu.northeastern.khoury.ds.domain.model.MenuItemIngredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public IngredientServingSize map(MenuItemIngredient menuItemIngredient) {
        final String name = menuItemIngredient.getIngredient().getName();
        final int servingSize = menuItemIngredient.getServingSize();
        return new IngredientServingSize(name, servingSize);
    }
}
