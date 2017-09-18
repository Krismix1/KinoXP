package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import models.Admin;

import java.awt.event.ActionEvent;

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
    public void login(ActionEvent event)throws Exception{
        if(checkLogin())

    }

}
