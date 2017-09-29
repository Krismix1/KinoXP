package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.BookingLogic;
import logic.CustomerRepository;
import logic.SceneManager;
import models.Booking;
import models.Customer;

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
    public void bookShow(ActionEvent event) throws Exception {
        if (customer_type.getSelectedToggle() == null) {
            SceneManager.getInstance().displayError(null, null, "Please choose customer type");
            return;
        }
        if (customer_type.getSelectedToggle().toString().contains("Existing Customer")) {
            bookShowExistingCustomer();
        } else {
            bookShowNewCustomer();
        }
    }

    public void bookShowExistingCustomer() throws Exception {
        String userID = existingCustomer_userId.getText();
        if (userID.isEmpty()) {
            SceneManager.getInstance().displayError(null, null, "Please fill in the information");
            return;
        }
        bookingLogic.bookShowExistingCustomer(Integer.parseInt(userID), CustomerController.showP.getId());
        existingCustomer_userId.clear();
    }

    public void bookShowNewCustomer() throws Exception {
        String customerName = newCustomer_name.getText();
        String customerEmail = newCustomer_email.getText();

        if (customerEmail.isEmpty() || customerName.isEmpty()) {
            SceneManager.getInstance().displayError(null, null, "Please fill in the information");
            return;
        }

        Customer customer = new Customer();
        customer.setName(customerName);
        customer.setEmail(customerEmail);
        customer = CustomerRepository.getInstance().save(customer);
        Booking booking = new Booking(customer.getId(), CustomerController.showP.getId());
        bookingLogic.save(booking);

        SceneManager.getInstance().displayInformation(null, null, "Booking was saved under customer id " + customer.getId());
        newCustomer_email.clear();
        newCustomer_name.clear();

    }
}
