package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.MovieRepository;
import logic.SceneManager;
import logic.ShowsRepository;
import models.Show;

import java.sql.Timestamp;
import java.text.ParseException;


/**
 * Created by Vidas on 9/20/2017.
 */
public class AdminController {

    @FXML
    private TextField movieID;
    @FXML
    private TextField price;
    @FXML
    private DatePicker date;
    @FXML
    private TextField theater;
    @FXML
    private TextField availableSeats;
    @FXML
    private ComboBox<String> hour;
    @FXML
    private ComboBox<String> minutes;

    @FXML
    private void addShow(ActionEvent actionEvent) throws ParseException {
        String movie_id = movieID.getText();
        String hour1 = hour.getValue();
        String minute1 = minutes.getValue();
        String sqlTime = hour1 + ":" + minute1;

        if (hour1 == null || minute1 == null || date.getValue() == null || movie_id.isEmpty() ||
                theater.getText().isEmpty() || availableSeats.getText().isEmpty() || price.getText().isEmpty()) {
            SceneManager.getInstance().displayInformation(null, null, "Please put all values u dip");
        } else {
            System.out.println(date.getValue() + " " +sqlTime);
            Timestamp dateTime = Timestamp.valueOf(date.getValue() + " " +sqlTime+":00");
            int theater_ = Integer.parseInt(theater.getText());
            int available_seats = Integer.parseInt(availableSeats.getText());
            double price_ = Double.parseDouble(price.getText());

            Show show = new Show();
            show.setAvailableSeats(available_seats);
            show.setPrice(price_);
            show.setDateTime(dateTime.toLocalDateTime());
            show.setTheater(theater_);
            show.setMovie(MovieRepository.instance.get(Integer.parseInt(movie_id)));

            ShowsRepository.instance.save(show);
        }
    }

    @FXML
    public void loadHoursToCombo(MouseEvent mouseEvent) {
        ObservableList<String> hours = FXCollections.observableArrayList();
        ObservableList<String> minute = FXCollections.observableArrayList();
        for (int i = 0; i < 24; i++) {
            hours.add(Integer.toString(i));
        }
        hour.setItems(hours);
        minute.addAll("00", "15", "30", "45");
        minutes.setItems(minute);
    }
}
