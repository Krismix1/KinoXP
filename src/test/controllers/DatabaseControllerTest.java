package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Chris on 18-Sep-17.
 */
public class DatabaseControllerTest {
    @Test
    public void getConnection() throws Exception {
        assertNotNull(DatabaseController.getConnection());
    }

}