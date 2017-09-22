package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * Created by George Stratulat on 18/09/2017.
 */
public class StartController {

    @FXML
    private ChoiceBox<String> choiceBoxStart;

    @FXML
    private Button enterButton;

    private ObservableList<String> choiceStart = FXCollections.observableArrayList("Admin", "User");

    @FXML
    public void initialize() {
        choiceBoxStart.setItems(choiceStart);

    }

    @FXML
    private void enter(ActionEvent event) throws Exception {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (choiceBoxStart.getValue().equals("Admin")) {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/AdminLoginWindow.fxml"));
            Scene scene = new Scene(root, 1024, 720);
            stage.setScene(scene);
            stage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/CustomerWindow.fxml"));
            Scene scene = new Scene(root, 1024, 720);
            stage.setScene(scene);
            stage.show();
        }
    }

}
