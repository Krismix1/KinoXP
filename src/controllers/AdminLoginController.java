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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import models.Admin;


/**
 * Created by George Stratulat on 18/09/2017.
 */
public class AdminLoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    public boolean checkLogin(String password){
        if(Admin.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }

    }

    @FXML
    public void login(javafx.event.ActionEvent event)throws Exception{
        if(checkLogin(passwordField.getText()) == true){
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Random.fxml"));
            Scene scene = new Scene(root,1024,720);
            stage.setScene(scene);
            stage.show();


        }

    }

}
