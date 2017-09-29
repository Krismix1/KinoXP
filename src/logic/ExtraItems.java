package logic;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Vidas on 9/25/2017.
 */
public class ExtraItems {


  public   static java.util.ArrayList<String> items = new ArrayList<String>();
    public static java.util.ArrayList<String> addExtraShit(String item) {
        items.add(item);
        return items;
    }

    public void addExtraStuff(int totalItems, int AccountID, double FinalPrice) {


        try {

            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO `Extras` (`ID`, `totalItems`, `AccoundID`, `FinalPrice`) " +
                        "VALUES (NULL," + totalItems +"," + AccountID + "," + FinalPrice +")" ;

            System.out.println(sql);
            stmt.executeUpdate(sql);
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
