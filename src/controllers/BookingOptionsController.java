package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.BookingLogic;

/**
 * Created by Tibi on 22/09/2017.
 */
public class BookingOptionsController {
    @FXML
    private javafx.scene.control.ToggleGroup customer_type;
    @FXML
    private javafx.scene.control.TextField existingCustomer_userId;
    @FXML
    private javafx.scene.control.TextField newCustomer_name;
    @FXML
    private javafx.scene.control.TextField newCustomer_email;

    private BookingLogic bookingLogic = new BookingLogic();

    @FXML
    public void bookShow(ActionEvent event)throws Exception {
        if (customer_type.getSelectedToggle().toString().contains("Existing Customer")) {
            bookShowExistingCustomer();
        }
        else {
            bookShowNewCustomer();
        }
    }

    public void bookShowExistingCustomer() throws Exception {
        bookingLogic.bookShowExistingCustomer(19, Integer.parseInt(existingCustomer_userId.getText()));
    }

    public void bookShowNewCustomer() throws Exception {
        System.out.println(newCustomer_name.getText());
        System.out.println(newCustomer_email.getText());
    }
}
