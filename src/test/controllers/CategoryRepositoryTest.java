package controllers;

import logic.CategoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 22-Sep-17.
 */
class CategoryRepositoryTest {
    CategoryRepository categoryRepository = CategoryRepository.instance;
    @Test
    void get() {
        assertNotNull(categoryRepository.get(1));
    }

}