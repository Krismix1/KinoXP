package controllers;

import models.Show;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 22-Sep-17.
 */
class ShowsControllerTest {
    @Test
    void getAll() {
        ShowsController showsController = new ShowsController();
        List<Show> shows = showsController.getAll();
        assertNotNull(shows);
        System.out.println(shows);
    }

}