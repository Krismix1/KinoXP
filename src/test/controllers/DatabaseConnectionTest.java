package controllers;

import logic.DatabaseConnection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 18-Sep-17.
 */
public class DatabaseConnectionTest {
    @Test
    public void getConnection() throws Exception {
        assertNotNull(DatabaseConnection.getConnection());
    }

}