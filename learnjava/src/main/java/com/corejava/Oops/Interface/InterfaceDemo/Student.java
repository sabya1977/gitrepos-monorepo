package com.corejava.Oops.Interface.InterfaceDemo;

public class Student implements Comparable<Student> {

    private int roll;
    private String name;

    public Student (int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    @Override
    public int compareTo (Student student) {
        return this.name.compareTo(student.name);
        // if (this.roll > student.roll) {
        //     return 1;
        // }
        // else if (this.roll < student.roll) {
        //     return -1;
        // }
        // else {return 0;}
    }

    

    @Override
    public String toString() {
        String stdString = Integer.toString(this.roll) + " " + " " + this.name;
        return stdString;
    }

}
