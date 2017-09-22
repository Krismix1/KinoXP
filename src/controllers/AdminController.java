package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;



/**
 * Created by Vidas on 9/20/2017.
 */
public class AdminController {

    @FXML
    private javafx.scene.control.TextField movieID;
    @FXML
    private javafx.scene.control.TextField price;
    @FXML
    private javafx.scene.control.DatePicker date;
    @FXML
    private javafx.scene.control.TextField theater;
    @FXML
    private javafx.scene.control.TextField availableSeats;
    @FXML
    private javafx.scene.control.ComboBox hour;
    @FXML
    private javafx.scene.control.ComboBox minutes;




    @FXML
    public void addShow(ActionEvent actionEvent) throws ParseException {


        String movie_id = movieID.getText();
        String hour1 = (String) hour.getValue();
        String minute1 = (String) minutes.getValue();
        String sqlTime = hour1 + ":" + minute1;


        if (hour1 == null || minute1 == null ||  date.getValue() == null || movie_id.isEmpty() ||
           theater.getText().isEmpty() || availableSeats.getText().isEmpty() || price.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Please put all values u dip");
        } else {
            java.sql.Date sqlDate = java.sql.Date.valueOf(date.getValue());
            int theater_ = Integer.parseInt(theater.getText());
            int available_seats = Integer.parseInt(availableSeats.getText());
            double price_ = Double.parseDouble(price.getText());


             addActivity(movie_id, sqlDate, theater_, available_seats, price_, sqlTime);
        }
    }

    @FXML
    public void loadHoursToCombo(MouseEvent mouseEvent) {
        ObservableList<String> hours = FXCollections.observableArrayList();
        ObservableList<String> minute = FXCollections.observableArrayList();
        for (int i = 0; i <= 24; i++) {
            hours.add(Integer.toString(i));
        }
        hour.setItems(hours);
        minute.addAll("00","15","30","45");
        minutes.setItems(minute);
    }



    public static void addActivity(String movie_id, java.sql.Date date, int theater, int available_seats, double price, String sqlTime) {


        try {
            Connection con = DatabaseController.getConnection();
            Statement stmt = con.createStatement();

            String sql = "INSERT INTO shows " +
                    "VALUES " +
                    "(NULL, "
                    +"'"+ movie_id +"'  ,"
                    +"'"+ date +" " + sqlTime +  "'  ,"
                    +"'"+ theater      +"'  ,"
                    +"'"+ available_seats +"'  ,"
                    +"'"+ price      +"'  "
                    +");                      ";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
