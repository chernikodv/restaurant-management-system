package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.dto.NutritionFacts;
import edu.northeastern.khoury.ds.domain.model.Category;
import edu.northeastern.khoury.ds.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public NutritionFacts computeNutritionFacts(Integer id) {
        return categoryRepository.computeNutritionFacts(id);
    }
}
