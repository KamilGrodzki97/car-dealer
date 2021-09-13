package com;

import java.util.ArrayList;

public class User {
    String firstName;
    String lastName;
    String city;
    String street;
    String houseNumber;
    ArrayList<Car> cars;

    public User(String firstName, String lastName, String city, String street, String houseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        cars = new ArrayList<Car>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName  +
                ", " + city +
                ", ul. " + street +
                " " + houseNumber;
    }
}
