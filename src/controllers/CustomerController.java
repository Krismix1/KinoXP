package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.BookingsLoader;
import logic.SceneManager;
import logic.ShowsRepository;
import models.Show;

public class CustomerController {
    @FXML
    private TableView<Show> moviesTable;
    @FXML
    private TableColumn<Show, String> nameColumn;
    @FXML
    private TableColumn<Show, String> categoryColumn;
    @FXML
    private TableColumn<Show, String> dateColumn;
    @FXML
    private TextField myBookingsUserID;
    @FXML
    private ComboBox myBookings;


BookingsLoader bookingsLoader = new BookingsLoader();

    public void displayMovies() {

        ShowsRepository showsController = ShowsRepository.instance;
        ObservableList<Show> movieData = FXCollections.observableArrayList(showsController.getAll());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        moviesTable.setItems(movieData);
    }


    public void displayBookings() {



        String userID = myBookingsUserID.getText();

        if (userID.isEmpty())
          SceneManager.getInstance().displayInformation(null, null, "Please put ID u dip");
        else {
            myBookings.setItems(bookingsLoader.customerOrder(userID));


        }
    }



    @FXML
    private void initialize() {
        displayMovies();
    }

}
