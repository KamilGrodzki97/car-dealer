package com;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button sellBtn;
    @FXML
    public ListView carsView;
    @FXML
    public ListView usersView;
    @FXML
    public Button addCarBtn;
    @FXML
    public Button userBtn;

    @FXML
    public void sell(){
        if(carsView.getSelectionModel().getSelectedItem()!=null&& usersView.getSelectionModel().getSelectedItem()!=null){
            ((User) usersView.getSelectionModel().getSelectedItem()).cars.add((Car) carsView.getSelectionModel().getSelectedItem());
            carDealer.getInstance().getCars().remove(carsView.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    public void invokeUsers(){
        Dialog<ButtonType> dialog=new Dialog<>();
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Users.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Error");
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }

    @FXML
    public void addCar(){
            Dialog<ButtonType> dialog=new Dialog<>();
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("addCar.fxml"));
            try{
                dialog.getDialogPane().setContent(fxmlLoader.load());
            }catch (IOException e){
                System.out.println("couldn't load the dialog");
            }
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Optional<ButtonType> result = dialog.showAndWait();
            if(result.isPresent()&& result.get() == ButtonType.OK){
                CarController controller=fxmlLoader.getController();
                Car car = controller.addCar();
                if(car == null){
                    addCar();
                    return;
                }
                carDealer.getInstance().getCars().add(car);
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        carsView.setCellFactory(param -> new ListCell<Car>() {
            @Override
            protected void updateItem(Car item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getCarName() == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });
        carsView.setItems(carDealer.getInstance().getCars());

        usersView.setCellFactory(param -> new ListCell<User>() {
            @Override
            protected void updateItem(User item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getFirstName() == null || item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });
        usersView.setItems(carDealer.getInstance().getUsers());
    }
}
