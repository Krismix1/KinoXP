package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import logic.MovieRepository;
import logic.SceneManager;
import logic.ShowsRepository;
import models.Movie;
import models.Show;

import java.sql.Timestamp;
import java.text.ParseException;


/**
 * Created by Vidas on 9/20/2017.
 */
public class AdminController {

    @FXML
    private ComboBox<Movie> movies;
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
        Movie movie = this.movies.getValue();
        String hour1 = hour.getValue();
        String minute1 = minutes.getValue();
        String sqlTime = hour1 + ":" + minute1;

        if (hour1 == null || minute1 == null || date.getValue() == null || movie == null ||
                theater.getText().isEmpty() || availableSeats.getText().isEmpty() || price.getText().isEmpty()) {
            SceneManager.getInstance().displayInformation(null, null, "Please put all values u dip");
        } else {
            Timestamp dateTime = Timestamp.valueOf(date.getValue() + " " + sqlTime + ":00");
            int theater_ = Integer.parseInt(theater.getText());
            int available_seats = Integer.parseInt(availableSeats.getText());
            double price_ = Double.parseDouble(price.getText());

            Show show = new Show();
            show.setAvailableSeats(available_seats);
            show.setPrice(price_);
            show.setDateTime(dateTime.toLocalDateTime());
            show.setTheater(theater_);
            show.setMovie(movie);

            ShowsRepository.instance.save(show);

            SceneManager.getInstance().displayInformation("Show creation", null, "The show was created.");

            price.clear();
            date.setValue(null);
            theater.clear();
            availableSeats.clear();
            hour.setValue(null);
            minutes.setValue(null);
            movies.setValue(null);
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

    @FXML
    private void initialize() {
        movies.setItems(FXCollections.observableList(MovieRepository.instance.getAll()));
//        movies.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>() {
//            @Override
//            public ListCell<Movie> call(ListView<Movie> param) {
//                final ListCell<Movie> cell = new ListCell<Movie>() {
//                    @Override
//                    public void updateItem(Movie item,
//                                           boolean empty) {
//                        super.updateItem(item, empty);
//                        if (item != null) {
//                            setText(item.getTitle());
//                        } else {
//                            setText(null);
//                        }
//                    }
//                };
//                return cell;
//            }
//        });
    }
}
