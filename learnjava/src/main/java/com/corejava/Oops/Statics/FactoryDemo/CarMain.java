package com.corejava.Oops.Statics.FactoryDemo;

public class CarMain {
    public static void main(String[] args) {
        Car myCar = CarFactory.getCar("Sedan");
        myCar.deliver();
    }

}
