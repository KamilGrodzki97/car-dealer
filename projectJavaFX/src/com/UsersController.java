package com;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    @FXML
    public Button addUserBtn;
    @FXML
    public ListView usersListView;
    @FXML
    public ListView usersView;

    public void invokeAddUser() {
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddUser.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("couldn't load the dialog");
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddUserController controller = fxmlLoader.getController();
            User user = controller.addUser();

            if (user == null) {
                invokeAddUser();
                return;
            }
            carDealer.getInstance().getUsers().add(user);
        }
    }

    public void userClickView() {
        User user = (User) usersListView.getSelectionModel().getSelectedItem();
        if ((user != null)) {
            usersView.getItems().clear();
            usersView.getItems().addAll(user.getCars());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListView.setCellFactory(param -> new ListCell<User>() {
            @Override
            protected void updateItem(User item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null
                        || item.getFirstName() == null
                        || item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });
        usersListView.setItems(carDealer.getInstance().getUsers());
    }
}
