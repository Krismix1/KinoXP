package controllers;

import logic.MovieRepository;
import models.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 19-Sep-17.
 */
class MovieRepositoryTest {
    MovieRepository movieController = MovieRepository.instance;
    @Test
    void getByCategory() {
        assertTrue(movieController.getByCategory(new Category("Comedy")).size() == 0);
    }

    @Test
    void getAll() {
        assertNotNull(movieController.getAll());
    }

}