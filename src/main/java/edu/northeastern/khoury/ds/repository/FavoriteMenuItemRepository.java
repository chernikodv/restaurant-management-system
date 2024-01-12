package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.FavoriteMenuItem;
import edu.northeastern.khoury.ds.domain.model.FavoriteMenuItemId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteMenuItemRepository extends JpaRepository<FavoriteMenuItem, FavoriteMenuItemId> {
    @EntityGraph(attributePaths = { "menuItem", "menuItem.ingredients" })
    List<FavoriteMenuItem> findAllById_Username(String username);

    default List<FavoriteMenuItem> findByUsername(String username) {
        return findAllById_Username(username);
    }
}
