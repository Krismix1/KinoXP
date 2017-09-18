package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tibi on 18/09/2017.
 */
public class DatabaseController {
    private final static String URL = "";
    private final static String DB_NAME = "";
    private final static String USER = "";
    private final static String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    URL + DB_NAME,
                    USER,
                    PASS);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
