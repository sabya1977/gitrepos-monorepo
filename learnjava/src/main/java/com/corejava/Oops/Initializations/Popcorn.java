package com.corejava.Oops.Initializations;
public class Popcorn {

    public static final int CALORIES;
    private String brand;

    static { // static initializer of the class for static variables

        System.out.println("In static block");
        CALORIES = 109;
    }

    { //instance initializer gets invoked after static initializer for object.
        System.out.println("Instance initializer");
        brand = "Magic"; // will be overriden by constructor assignment.
    }

    public Popcorn() { // Object constructor invoked after instance initializer.
        System.out.println("In Constructor");
        brand = "Popcorn Magic";
    }

    public String getBrand() {
        return brand;
    }

    public static void main(String[] args) {

        Popcorn popcorn = new Popcorn();
        System.out.println(popcorn.getBrand());                   
    }
}
