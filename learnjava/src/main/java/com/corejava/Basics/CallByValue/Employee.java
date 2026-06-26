package com.corejava.Basics.CallByValue;
import java.util.Random;

public class Employee {
    private int id;
    private String name;
    private double salary;
    
    { // initialization block - gets executed before constructor
        var generator = new Random();
        id = generator.nextInt(10_000, 100_000);
    }
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setSal (double salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }
}