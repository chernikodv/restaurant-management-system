package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.dto.MenuItemResponse;
import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.dto.menu.AddFavoriteMenuItemRequest;
import edu.northeastern.khoury.ds.domain.dto.menu.TrendingMenuItemResponse;
import edu.northeastern.khoury.ds.domain.model.Account;
import edu.northeastern.khoury.ds.domain.model.FavoriteMenuItem;
import edu.northeastern.khoury.ds.domain.model.FavoriteMenuItemId;
import edu.northeastern.khoury.ds.domain.model.MenuItem;
import edu.northeastern.khoury.ds.domain.view.TrendingMenuItem;
import edu.northeastern.khoury.ds.exception.ResourceNotFoundException;
import edu.northeastern.khoury.ds.mapper.MenuItemMapper;
import edu.northeastern.khoury.ds.repository.MenuItemRepository;
import edu.northeastern.khoury.ds.repository.view.TrendingMenuItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final TrendingMenuItemRepository trendingMenuItemRepository;
    private final AccessTokenInfoExtractor accessTokenInfoExtractor;
    private final FavoriteMenuItemService favoriteMenuItemService;
    private final MenuItemRepository menuItemRepository;
    private final AccountService accountService;
    private final MenuItemMapper menuItemMapper;

    public MenuItem findById(Integer menuItemId) {
        return menuItemRepository.findById(menuItemId).orElseThrow(ResourceNotFoundException::new);
    }

    public List<MenuItemResponse> findByCategory(Integer categoryId) {
        final List<MenuItem> menuItems = menuItemRepository.findByCategoryId(categoryId);
        return menuItems.stream().map(menuItemMapper::mapToResponse).toList();
    }

    public List<MenuItemResponse> findFavorite() {
        final String username = accessTokenInfoExtractor.getUsername();
        final List<FavoriteMenuItem> favoriteMenuItems = favoriteMenuItemService.findByUsernameLoadMenuItemIngredients(username);
        return favoriteMenuItems.stream().map(FavoriteMenuItem::getMenuItem).map(menuItemMapper::mapToResponse).toList();
    }

    public List<MenuItemResponse> deleteFavorite(Integer menuItemId) {
        final String username = accessTokenInfoExtractor.getUsername();

        final FavoriteMenuItemId favoriteMenuItemId = new FavoriteMenuItemId();
        favoriteMenuItemId.setMenuItemId(menuItemId);
        favoriteMenuItemId.setUsername(username);

        favoriteMenuItemService.deleteById(favoriteMenuItemId);

        final List<FavoriteMenuItem> favoriteMenuItems = favoriteMenuItemService.findByUsernameLoadMenuItemIngredients(username);
        return favoriteMenuItems.stream().map(FavoriteMenuItem::getMenuItem).map(menuItemMapper::mapToResponse).toList();
    }

    public MenuItemResponse addFavorite(AddFavoriteMenuItemRequest request) {
        final MenuItem menuItem = findById(request.menuItemId());
        final String username = accessTokenInfoExtractor.getUsername();
        final Account account = accountService.findByUsername(username);

        favoriteMenuItemService.save(account, menuItem);
        return menuItemMapper.mapToResponse(menuItem);
    }

    public List<TrendingMenuItemResponse> findTrending() {
        return trendingMenuItemRepository.findAll().stream()
                .map(menuItemMapper::mapToTrendingResponse)
                .toList();
    }
    @Transactional
    public NutritionFacts computeNutritionFacts(Integer id) {
        return menuItemRepository.findNutritionFacts(id);
    }
}
