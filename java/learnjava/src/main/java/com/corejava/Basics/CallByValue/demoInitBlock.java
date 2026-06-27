package com.corejava.Basics.CallByValue;

public class demoInitBlock {
    Employee fred = new Employee("Fred", 100_00);

    public void getId() {
        System.out.printf("Fred's Employee ID: %d\n", fred.getId());
    }
    public static void main(String[] args) {
        demoInitBlock ObjInitBlock = new demoInitBlock();
        ObjInitBlock.getId();
    }
    
}
