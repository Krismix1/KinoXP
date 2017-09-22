package controllers;

import logic.ShowsRepository;
import models.Show;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 22-Sep-17.
 */
class ShowsRepositoryTest {
    @Test
    void getAll() {
        ShowsRepository showsController = ShowsRepository.instance;
        List<Show> shows = showsController.getAll();
        assertNotNull(shows);
    }

}