package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tibi on 18/09/2017.
 */
public class DatabaseConnection {
    private final static String URL = "jdbc:mysql://52.15.193.92:3306/";
    private final static String DB_NAME = "KinoXp";
    private final static String USER = "tibi";
    private final static String PASS = "tibi";

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
