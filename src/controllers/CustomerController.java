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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.*;
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
    @FXML
    private TextField extrasUserID;
    @FXML
    private javafx.scene.control.ComboBox extraItemsCombo;
    @FXML
    private javafx.scene.control.TextArea extraItemsArea;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private javafx.scene.control.TextArea TotalPriceArea;
    BookingsLoader bookingsLoader = new BookingsLoader();
    ExtraItems extraItems = new ExtraItems();


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
    public void addExtras() {

        int totalItems = Integer.parseInt(totalPriceLabel.getText());
        int AccountID = Integer.parseInt(extrasUserID.getText());
        double FinalPrice = Double.parseDouble(TotalPriceArea.getText());

        String userID = extrasUserID.getText();

        if (userID.isEmpty())
            SceneManager.getInstance().displayInformation(null, null, "Please put ID u dip");
        else {
            extraItems.addExtraStuff(totalItems, AccountID, FinalPrice);

        }
    }


    @FXML
    public void loadExtrasToCombo(MouseEvent mouseEvent) {
        ObservableList<String> extras = FXCollections.observableArrayList();
        extras.addAll("Popcorn", "Sweet", "Drink");
        extraItemsCombo.setItems(extras);
    }

    @FXML
    public void addExtaItemAction(ActionEvent actionEvent) {

        String item = (String) extraItemsCombo.getValue();

        if (extraItemsCombo.getValue()== null) {
            SceneManager.getInstance().displayInformation(null, null, "Please put value u dip");
        } else {
            String listString = "";

            for (String s : ExtraItems.addExtraShit(item)) {
                listString += s + "\n";
                System.out.println();
            }
            extraItemsArea.setText(listString);
            String sizes = Integer.toString(ExtraItems.items.size());
            totalPriceLabel.setText(sizes);
            System.out.println(sizes);
        }
    }


    @FXML//Remove last extra item
    public void removeLastExtraItem(ActionEvent actionEvent) {
        ExtraItems.items.remove(ExtraItems.items.size() - 1);
        extraItemsArea.setText("");
        String listString = "";

        for (String s : ExtraItems.items) {
            listString += s + "\n";
            System.out.println();
        }
        extraItemsArea.setText(listString);
        String sizes = Integer.toString(ExtraItems.items.size());
        totalPriceLabel.setText(sizes);
    }



    @FXML//calculate total price
    public void toalPriceAction(ActionEvent actionEvent) {
        if (totalPriceLabel == null)
            SceneManager.getInstance().displayInformation(null, null, "Please add extra items u dip");
        else {

            int totalNumber = Integer.parseInt(totalPriceLabel.getText());
            int totalPrice = totalNumber * 10;

            TotalPriceArea.setText(Integer.toString(totalPrice));


        }
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

    public static Show showP;
    @FXML
    private void book(ActionEvent event) throws Exception {
        try {
            Show show = showP =moviesTable.getSelectionModel().getSelectedItem();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/BookingOptions.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle(show.getMovieTitle());
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
