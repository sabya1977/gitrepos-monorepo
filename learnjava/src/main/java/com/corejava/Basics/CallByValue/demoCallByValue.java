package com.corejava.Basics.CallByValue;

public class demoCallByValue {

    String ename = "Fred";
    double esalary = 155000;
    String mname = "John";
    Employee fred = new Employee(ename, esalary);
    Manager mgr = new Manager (mname);
    public static void main(String[] args) {
        demoCallByValue objdc = new demoCallByValue();   
        objdc.helper();     
    }

    public void helper () {
        System.out.println("Old Salary: "+ fred.getSalary());
        // var newsal = mgr.raiseSalary(fred,5);
        mgr.raiseSalary(fred,5);
        // fred.setSal(newsal);
        System.out.println("New Salary: "+ fred.getSalary());
    }

}
