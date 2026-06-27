package com.corejava.Oops.Interface.FlightDemo;

public class Flight extends Event implements Buyable, Comparable<Flight> {

    private String sourceCity;
    private String destCity;
    private double price;

    @Override
    public double price() {
        return this.price;
    }

    public Flight(int price, String srcString, String desString, int durInt) {
        
        String about = srcString + " To " + desString;
        int duration = durInt;
        super(about, duration);
        this.price = price;
        this.sourceCity = srcString;
        this.destCity = desString;

    }

    @Override
    public int compareTo (Flight other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Flight: " + about + " | Duration : " + duration + " | Source City: " + sourceCity + " | Destination City: "
                + destCity + " | Ticket Price: " + price;
    }

    

}
