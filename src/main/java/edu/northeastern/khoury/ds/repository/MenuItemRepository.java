package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.model.MenuItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    @EntityGraph(attributePaths = { "ingredients.ingredient" })
    List<MenuItem> findByCategory_Id(Integer categoryId);

    @Procedure(name = "menu_item_nutrition_facts")
    NutritionFacts findNutritionFacts(@Param("menu_item_id") Integer menuItemId);

    @Procedure(name = "menu_item_average_nutrition_facts_per_category")
    NutritionFacts computeAverageNutritionFactsPerCategory();

    default List<MenuItem> findByCategoryId(Integer categoryId) {
        return findByCategory_Id(categoryId);
    }
}
