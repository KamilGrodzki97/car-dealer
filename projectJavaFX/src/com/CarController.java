package com;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CarController implements Initializable {

    @FXML
    public TextField carNameTextField;
    @FXML
    public TextField carTypeTextField;
    @FXML
    public TextField numberOfPersonsTextField;
    @FXML
    public TextField numberOfDorsTextField;
    @FXML
    public TextField numberplatesTextField;
    @FXML
    public TextField HPTextField;

    @FXML
    public Car addCar(){
        if(carNameTextField.getText().trim().isEmpty()||carTypeTextField.getText().trim().isEmpty()||
                numberOfPersonsTextField.getText().trim().isEmpty()|
                        numberOfDorsTextField.getText().trim().isEmpty()|
                        numberplatesTextField.getText().trim().isEmpty()|
                        HPTextField.getText().trim().isEmpty()){
            Error.display();
            return null;
        }
        return new Car(CarModel.carName.getValue()
                , CarModel.carType.getValue()
                , CarModel.numberOfPersons.getValue()
                , CarModel.numberOfDors.getValue()
                , CarModel.numberplates.getValue()
                , CarModel.HP.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        carNameTextField.textProperty().bindBidirectional(CarModel.carName);
        carTypeTextField.textProperty().bindBidirectional(CarModel.carType);
        numberOfPersonsTextField.textProperty().bindBidirectional(CarModel.numberOfPersons);
        numberOfDorsTextField.textProperty().bindBidirectional(CarModel.numberOfDors);
        numberplatesTextField.textProperty().bindBidirectional(CarModel.numberplates);
        HPTextField.textProperty().bindBidirectional(CarModel.HP);

    }


}
