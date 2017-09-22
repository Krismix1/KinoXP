package controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 18-Sep-17.
 */
public class DatabaseControllerTest {
    @Test
    public void getConnection() throws Exception {
        assertNotNull(DatabaseController.getConnection());
    }

}