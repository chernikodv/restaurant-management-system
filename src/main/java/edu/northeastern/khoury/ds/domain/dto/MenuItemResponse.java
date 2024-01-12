package edu.northeastern.khoury.ds.domain.dto;

import java.math.BigDecimal;
import java.util.List;

public record MenuItemResponse (int id,
                                String name,
                                String description,
                                BigDecimal price,
                                List<IngredientServingSize> ingredients) {
}
