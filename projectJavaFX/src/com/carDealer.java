package com;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class carDealer {
    private static carDealer instance = new carDealer();

    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<User> users = FXCollections.observableArrayList();

    public static carDealer getInstance(){
        return instance;
    }

    public ObservableList<Car> getCars() {
        return cars;
    }

    public ObservableList<User> getUsers() {
        return users;
    }
}
