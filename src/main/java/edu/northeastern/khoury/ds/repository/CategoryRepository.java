package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Procedure(name = "category_average_nutrition_facts")
    NutritionFacts computeNutritionFacts(@Param("category_id") Integer categoryId);
}
