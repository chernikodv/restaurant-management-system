package edu.northeastern.khoury.ds.mapper;

import edu.northeastern.khoury.ds.domain.dto.IngredientServingSize;
import edu.northeastern.khoury.ds.domain.dto.MenuItemResponse;
import edu.northeastern.khoury.ds.domain.dto.menu.TrendingMenuItemResponse;
import edu.northeastern.khoury.ds.domain.model.MenuItem;
import edu.northeastern.khoury.ds.domain.model.MenuItemNameQuantity;
import edu.northeastern.khoury.ds.domain.view.TrendingMenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuItemMapper {

    private final IngredientMapper ingredientMapper;

    public MenuItemResponse mapToResponse(MenuItem menuItem) {
        final List<IngredientServingSize> ingredients = menuItem.getIngredients().stream()
                .map(ingredientMapper::map)
                .toList();
        return new MenuItemResponse(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), menuItem.getPrice(), ingredients);
    }

    public TrendingMenuItemResponse mapToTrendingResponse(TrendingMenuItem menuItem) {
        return new TrendingMenuItemResponse(menuItem.getName(), menuItem.getPrice(), menuItem.getNumberOfLikes());
    }
}
