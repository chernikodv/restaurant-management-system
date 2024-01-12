package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.model.Account;
import edu.northeastern.khoury.ds.domain.model.FavoriteMenuItem;
import edu.northeastern.khoury.ds.domain.model.FavoriteMenuItemId;
import edu.northeastern.khoury.ds.domain.model.MenuItem;
import edu.northeastern.khoury.ds.repository.FavoriteMenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteMenuItemService {

    private final FavoriteMenuItemRepository favoriteMenuItemRepository;

    public List<FavoriteMenuItem> findByUsername(String username) {
        return favoriteMenuItemRepository.findByUsername(username);
    }

    public List<FavoriteMenuItem> findByUsernameLoadMenuItemIngredients(String username) {
        return favoriteMenuItemRepository.findByUsername(username);
    }

    public void deleteById(FavoriteMenuItemId id) {
        favoriteMenuItemRepository.deleteById(id);
    }

    public boolean existsById(FavoriteMenuItemId id) {
        return favoriteMenuItemRepository.existsById(id);
    }

    public void save(Account account, MenuItem menuItem) {
        final FavoriteMenuItemId favoriteMenuItemId = new FavoriteMenuItemId();
        favoriteMenuItemId.setUsername(account.getUsername());
        favoriteMenuItemId.setMenuItemId(menuItem.getId());

        final FavoriteMenuItem favoriteMenuItem = new FavoriteMenuItem();
        favoriteMenuItem.setLikedAt(LocalDateTime.now());
        favoriteMenuItem.setId(favoriteMenuItemId);
        favoriteMenuItem.setMenuItem(menuItem);
        favoriteMenuItem.setAccount(account);

        favoriteMenuItemRepository.save(favoriteMenuItem);
    }
}
