package com.corejava.Basics.CallByValue;

public class Manager {

    String name;
    public Manager (String name) {
        this.name = name;
    }
    public void raiseSalary (Employee e, double byPercent) {
        // return e.getSalary() + (e.getSalary() * byPercent / 100);
        // e.setSal(e.getSalary() + (e.getSalary() * byPercent / 100));
        var newsal = e.getSalary() + (e.getSalary() * byPercent / 100);
        e = new Employee(e.getName(), newsal); // e no longer points to fred
    }
    
}
