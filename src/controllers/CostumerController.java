package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Movie;
import models.Show;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CostumerController {
    @FXML
    private TableView<Show> moviesTable;
    @FXML
    private TableColumn<Show, String> nameColumn;
    @FXML
    private TableColumn<Show, String> categoryColumn;
    @FXML
    private TableColumn<Show, String> dateColumn;

    private ObservableList<Show> movieData;

    public void displayMovies() {

        ShowsController showsController = new ShowsController();
        movieData = FXCollections.observableArrayList(showsController.getAll());
        System.out.println("Debug");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("movie"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("movie"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));

        moviesTable.setItems(movieData);
    }

    @FXML
    private void initialize() {
        displayMovies();
    }

}
