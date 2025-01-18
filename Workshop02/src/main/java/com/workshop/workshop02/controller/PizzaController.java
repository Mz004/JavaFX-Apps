package com.workshop.workshop02.controller;

import com.workshop.workshop02.model.Pizza;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class PizzaController {

    @FXML
    private TextField textCustName;
    @FXML
    private TextField textCustPhone;
    @FXML
    private RadioButton rdSmall;
    @FXML
    private RadioButton rdMedium;
    @FXML
    private RadioButton rdLarge;
    @FXML
    private RadioButton rdExtraLarge;
    @FXML
    private ToggleGroup toggleSize;
    @FXML
    private RadioButton rdNormal;
    @FXML
    private RadioButton rdThin;
    @FXML
    private RadioButton rdDeep;
    @FXML
    private ToggleGroup toggleType;
    @FXML
    private CheckBox checkBoxPineapple;
    @FXML
    private CheckBox checkBoxExtraCheese;
    @FXML
    private CheckBox checkBoxShrimps;
    @FXML
    private CheckBox checkBoxMushrooms;
    @FXML
    private CheckBox checkBoxAnchovies;
    @FXML
    private CheckBox checkBoxJalapeno;
    @FXML
    private CheckBox checkBoxGarlic;
    @FXML
    private CheckBox checkBoxDacon;
    @FXML
    private CheckBox checkBoxSpinach;
    @FXML
    private CheckBox checkBoxPepperoni;
    @FXML
    private CheckBox checkBoxDriedTomatoes;
    @FXML
    private CheckBox checkBoxHam;
    @FXML
    private CheckBox checkBoxBeef;
    @FXML
    private CheckBox checkBoxBacon;
    @FXML
    private CheckBox checkBoxShreddedChicken;
    @FXML
    private CheckBox checkBoxGrilledChicken;
    @FXML
    private TextField textQuantity;
    @FXML
    private TextArea textSummary;

    private final List<Pizza> pizzaOrders = FXCollections.observableArrayList();

    // method to validate user input
    private boolean isFormValid() {
        String customerName = textCustName.getText();
        String customerPhone = textCustPhone.getText();
        String quantityText = textQuantity.getText();

        // Validate customer name
        if (customerName == null || customerName.trim().isEmpty()) {
            showAlert("Validation Error", "Customer name cannot be empty.");
            return false;
        }

        // Validate customer phone (you can add a more robust regex for phone validation if needed)
        if (customerPhone == null || customerPhone.trim().isEmpty() || !customerPhone.matches("\\d{10}")) {
            showAlert("Validation Error", "Please enter a valid 10-digit phone number.");
            return false;
        }

        // Validate quantity
        try {
            int quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                showAlert("Validation Error", "Quantity must be greater than zero.");
                return false;
            }
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Quantity must be a valid number.");
            return false;
        }

        // Validate pizza size selection
        if (toggleSize.getSelectedToggle() == null) {
            showAlert("Validation Error", "Please select a pizza size.");
            return false;
        }

        // Validate crust type selection
        if (toggleType.getSelectedToggle() == null) {
            showAlert("Validation Error", "Please select a crust type.");
            return false;
        }

        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // method to process order details
    @FXML
    public void placeOrder() {
        // Validation logic
        if (!isFormValid()) {
            return;
        }
        String customerName = textCustName.getText();
        String customerPhone = textCustPhone.getText();
        int quantity = Integer.parseInt(textQuantity.getText());

        String pizzaSize = ((RadioButton) toggleSize.getSelectedToggle()).getText();
        String crustType = ((RadioButton) toggleType.getSelectedToggle()).getText();

        List<String> selectedToppings = getSelectedToppings();

        Pizza pizza = new Pizza(customerName, customerPhone, pizzaSize, crustType, quantity, selectedToppings);

        // Add to pizza orders list
        pizzaOrders.add(pizza);

        // Display summary
        textSummary.setText(pizza.toString());
    }

    // method to clear all fields
    @FXML
    public void clearForm() {
        textCustName.clear();
        textCustPhone.clear();
        textQuantity.clear();
        toggleSize.selectToggle(rdSmall);
        toggleType.selectToggle(rdNormal);
        uncheckAllToppings();
        textSummary.clear();
    }

    private List<String> getSelectedToppings() {
        List<String> toppings = new ArrayList<>();
        if (checkBoxPineapple.isSelected()) toppings.add("Pineapple");
        if (checkBoxExtraCheese.isSelected()) toppings.add("Extra Cheese");
        if (checkBoxShrimps.isSelected()) toppings.add("Dried Shrimps");
        if (checkBoxMushrooms.isSelected()) toppings.add("Mushrooms");
        if (checkBoxAnchovies.isSelected()) toppings.add("Anchovies");
        if (checkBoxJalapeno.isSelected()) toppings.add("Jalapeno");
        if (checkBoxGarlic.isSelected()) toppings.add("Roasted Garlic");
        if (checkBoxDacon.isSelected()) toppings.add("Dacon");
        if (checkBoxSpinach.isSelected()) toppings.add("Spinach");
        if (checkBoxPepperoni.isSelected()) toppings.add("Pepperoni");
        if (checkBoxDriedTomatoes.isSelected()) toppings.add("Sun Dried Tomatoes");
        if (checkBoxHam.isSelected()) toppings.add("Ham");
        if (checkBoxBeef.isSelected()) toppings.add("Ground Beef");
        if (checkBoxBacon.isSelected()) toppings.add("Bacon");
        if (checkBoxShreddedChicken.isSelected()) toppings.add("Shredded Chicken");
        if (checkBoxGrilledChicken.isSelected()) toppings.add("Grilled Chicken");
        return toppings;
    }

    private void uncheckAllToppings() {
        checkBoxPineapple.setSelected(false);
        checkBoxExtraCheese.setSelected(false);
        checkBoxShrimps.setSelected(false);
        checkBoxMushrooms.setSelected(false);
        checkBoxAnchovies.setSelected(false);
        checkBoxJalapeno.setSelected(false);
        checkBoxGarlic.setSelected(false);
        checkBoxDacon.setSelected(false);
        checkBoxSpinach.setSelected(false);
        checkBoxPepperoni.setSelected(false);
        checkBoxDriedTomatoes.setSelected(false);
        checkBoxHam.setSelected(false);
        checkBoxBeef.setSelected(false);
        checkBoxBacon.setSelected(false);
        checkBoxShreddedChicken.setSelected(false);
        checkBoxGrilledChicken.setSelected(false);
    }
}
