package com.corejava.Oops.Statics.FactoryDemo;

public class CarFactory {

    // getCar is a factory method which returns the instance of another class
    public static Car getCar(String carType) {
        if (carType.equalsIgnoreCase("Sedan")) {
            return new Sedan("Sedan-Baleno", "AB-XC-567", 2025, 
                    30.5, true, 1000);
        } 
        if (carType.equalsIgnoreCase("Sedan")) {
            return new Suv ("Suv-Pajero", "SV-UU-567", 2025, 
                    50.5, true, 1500);
        }

        throw new IllegalArgumentException("Unknown car type");
    }
}
