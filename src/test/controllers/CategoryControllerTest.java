package controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 22-Sep-17.
 */
class CategoryControllerTest {
    CategoryController categoryController = new CategoryController();
    @Test
    void get() {
        assertNotNull(categoryController.get(1));
    }

}