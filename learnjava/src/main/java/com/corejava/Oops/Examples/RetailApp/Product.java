package com.corejava.Oops.Examples.RetailApp;
import java.util.Random;

public class Product {

    private int pid;
    private String pname;
    private double priceunit;

    public Product (String name, double price) {
        var generator = new Random();
        this.pid = generator.nextInt(10_000, 100_000);
        this.pname = name;
        this.priceunit = price;
    }

    public String getPname () {
        return pname;
    }

    public double getPrice () {
        return priceunit;
    }

    public int getPid () {
        return pid;
    }
}
