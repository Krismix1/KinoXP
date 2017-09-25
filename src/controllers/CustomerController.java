package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logic.BookingsLoader;
import logic.CategoryRepository;
import logic.SceneManager;
import logic.ShowsRepository;
import models.Category;
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
    private TableColumn<Show, String> actorsColumn;
    @FXML
    private TextField myBookingsUserID;
    @FXML
    private ComboBox myBookings;
    @FXML
    private ChoiceBox<Category> categoryOptions;
    BookingsLoader bookingsLoader = new BookingsLoader();

    public void displayMovies() {

        ShowsRepository showsController = ShowsRepository.instance;
        ObservableList<Show> movieData = FXCollections.observableArrayList(showsController.getAll());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        actorsColumn.setCellValueFactory(new PropertyValueFactory<>("actors"));
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

    public void displayCategories() {

        ObservableList<Category> categories = FXCollections.observableArrayList(CategoryRepository.instance.getAll());
        categoryOptions.setItems(categories);
    }

    @FXML
    public void displayCategory() {
        Category selected = categoryOptions.getSelectionModel().getSelectedItem();
        ObservableList<Show> movieData = FXCollections.observableArrayList(ShowsRepository.instance.getByCategory(selected));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        moviesTable.setItems(movieData);
    }


    public static DetailsController detailsController;

    @FXML
    private void initialize() {
        displayMovies();
        displayCategories();
    }

    @FXML
    private void showDetails(ActionEvent event) throws Exception {

        try {
            Show show = moviesTable.getSelectionModel().getSelectedItem();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/DetailsWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            detailsController.filmTitle.setText(show.getMovie().getTitle());
            detailsController.filmCat.setText(show.getMovie().getCategory().getName());
            detailsController.filmLimit.setText(Integer.toString(show.getMovie().getMinimum_age()));
            detailsController.filmDur.setText(Integer.toString(show.getMovie().getDuration()));
            detailsController.filmActors.setText(show.getMovie().getActors());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
