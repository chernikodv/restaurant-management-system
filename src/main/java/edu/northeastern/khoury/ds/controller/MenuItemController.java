package edu.northeastern.khoury.ds.controller;

import edu.northeastern.khoury.ds.domain.dto.MenuItemResponse;
import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.dto.menu.AddFavoriteMenuItemRequest;
import edu.northeastern.khoury.ds.domain.dto.menu.TrendingMenuItemResponse;
import edu.northeastern.khoury.ds.domain.view.TrendingMenuItem;
import edu.northeastern.khoury.ds.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @GetMapping
    public List<MenuItemResponse> find(@RequestParam Integer categoryId) {
        return menuItemService.findByCategory(categoryId);
    }

    @GetMapping(path = "/{id}/nutrition-facts")
    public NutritionFacts computeNutritionFacts(@PathVariable Integer id) {
        return menuItemService.computeNutritionFacts(id);
    }

    @GetMapping(path = "/trending")
    public List<TrendingMenuItemResponse> findTrending() {
        return menuItemService.findTrending();
    }

    @GetMapping(path = "/favorites")
    public List<MenuItemResponse> findFavorite() {
        return menuItemService.findFavorite();
    }

    @PostMapping(path = "/favorites")
    public MenuItemResponse addFavorite(@RequestBody AddFavoriteMenuItemRequest request) {
        return menuItemService.addFavorite(request);
    }

    @DeleteMapping(path = "/favorites/{menuItemId}")
    public List<MenuItemResponse> deleteFavorite(@PathVariable Integer menuItemId) {
        return menuItemService.deleteFavorite(menuItemId);
    }
}
