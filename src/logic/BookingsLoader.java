package logic;


        import models.Category;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import java.sql.ResultSet;

/**
 * Created by Vidas on 9/23/2017.
 */
public class BookingsLoader {


    public ObservableList<String> customerOrder(String userID) {

        java.util.List<String> userBooking = new ArrayList<String>();

        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `title`,date_time, price, theater FROM `shows`, `bookings`, `movies` WHERE shows.id = bookings.show_id AND shows.movie_id = movies.id AND bookings.account_id =" + userID );
            while (rs.next()) {

                userBooking.add(
                        rs.getString(1) + "| DATE: " +
                                rs.getString(2) + "| PRICE: " +
                                rs.getString(3) + "| THEATER: " +
                                rs.getString(4) + "  |");
            }
            ObservableList<String> list = FXCollections.observableArrayList();


            String listString = "";

            for (String s : userBooking) {
                listString += list.add(s);
            }
            return list;


        } catch (SQLException e) {
            e.printStackTrace();
            ObservableList<String> list2 = FXCollections.observableArrayList();
            list2.add("Failed to load");
            return list2;
        }
    }


}