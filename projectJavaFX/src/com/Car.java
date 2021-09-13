package com;

public class Car {
    String carName;
    String carType;
    String numberOfPersons;
    String numberOfDors;
    String numberplates;
    String HP;

    public Car(String carName, String carType, String numberOfPersons, String numberOfDors, String numberplates, String HP) {
        this.carName = carName;
        this.carType = carType;
        this.numberOfPersons = numberOfPersons;
        this.numberOfDors = numberOfDors;
        this.numberplates = numberplates;
        this.HP = HP;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(String numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public String getNumberOfDors() {
        return numberOfDors;
    }

    public void setNumberOfDors(String numberOfDors) {
        this.numberOfDors = numberOfDors;
    }

    public String getNumberplates() {
        return numberplates;
    }

    public void setNumberplates(String numberplates) {
        this.numberplates = numberplates;
    }

    public String getHP() {
        return HP;
    }

    public void setHP(String HP) {
        this.HP = HP;
    }

    public Car() {

    }

    @Override
    public String toString() {
        return
                "[" + numberplates + "], " + carName +
                ", " + carType  +
                ", Ilość osób:" + numberOfPersons  +
                ", Ilość drzwi:" + numberOfDors +
                ", " + HP + "HP";
    }
}
