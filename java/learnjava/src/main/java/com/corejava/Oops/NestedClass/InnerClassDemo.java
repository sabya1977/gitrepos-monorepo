package com.corejava.Oops.NestedClass;

class Human {

    private String name;

    public void walk () {
        System.out.println( this.name + " is walking...");
    }

    class Heart {

        public void vibrate () {
            System.out.println("Heart of " + name + " is working");
        }
    }

    Human (String name) {
        this.name = name;
    }
}

class Car {
    
    private String name;

    void drive () {
        System.out.println("Driving a new car my new " + this.name);
    }

    Car (String name) {
        this.name = name;
    }

    static class Wheel {

        void rolling () {
            System.out.println("Wheel of the new rolling ");
        }

    }

}

public class InnerClassDemo {

    public static void main(String[] args) {

        Human body = new Human("Sabya");
        body.walk();

        // you need an object of class Human (outer class) to create an object of 
        // Heart (inner class) becuse Heart class is a non-static member of Human.
        Human.Heart heart = body.new Heart();
        heart.vibrate();

        Car ByD = new Car("BYD");
        ByD.drive();

        // sicne Wheel is static 
        Car.Wheel wheel = new Car.Wheel();
        wheel.rolling();
    }

}
