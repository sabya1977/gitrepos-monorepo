package com.corejava.Oops.Statics.FactoryDemo;
public abstract class Car {

        private String make;
        private String model;
        int year;

        public String getMake() {
                return make;
        }

        public String getModel() {
                return model;
        }

        public int getyear() {
                return year;
        }

        public abstract void deliver();

        public Car (String make, String model, int year) {
                this.make = make;
                this.model = model;
                this.year = year;
        }
}


