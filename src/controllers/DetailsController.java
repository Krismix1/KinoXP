package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by George Stratulat on 22/09/2017.
 */
public class DetailsController {

    @FXML
    public Label filmTitle;
    @FXML
    public Label filmCat;
    @FXML
    public Label filmLimit;
    @FXML
    public Label filmDur;

    @FXML
    public void initialize(){
        CustomerController.detailsController=this;
    }


}
