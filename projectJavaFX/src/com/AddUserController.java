package com;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {

    @FXML
    public TextField firstNameTextField;
    @FXML
    public TextField lastNameTextField;
    @FXML
    public TextField cityTextField;
    @FXML
    public TextField streetTextField;
    @FXML
    public TextField houseNumberTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameTextField.textProperty().bindBidirectional(UserModel.name);
        lastNameTextField.textProperty().bindBidirectional(UserModel.surname);
        cityTextField.textProperty().bindBidirectional(UserModel.city);
        streetTextField.textProperty().bindBidirectional(UserModel.street);
        houseNumberTextField.textProperty().bindBidirectional(UserModel.houseNumber);
    }

    public User addUser(){
        if(firstNameTextField.getText().trim().isEmpty() || lastNameTextField.getText().trim().isEmpty()){
            Error.display();
            return null;
        }
        return new User(UserModel.name.getValue(),UserModel.surname.getValue(),UserModel.city.getValue(),
                UserModel.street.getValue(), UserModel.houseNumber.getValue());
    }
}
