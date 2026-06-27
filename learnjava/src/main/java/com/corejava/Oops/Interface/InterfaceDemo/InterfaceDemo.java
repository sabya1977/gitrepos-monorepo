package com.corejava.Oops.Interface.InterfaceDemo;

import java.util.ArrayList;
import java.util.Collections;

public class InterfaceDemo {
    public static void main(String[] args) {
        Student Mill = new Student(1000, "Mill");
        Student me = new Student(2000, "Sabya");        
        Student asad = new Student(3000, "Asad");    
        ArrayList <Student> student = new ArrayList<>();
        
        student.add(me);
        student.add(Mill);
        student.add(asad);

        for (Student std: student) {
            System.out.println(std);
        }

        Collections.sort(student);

        for (Student std: student) {
            System.out.println(std);
        }
    }
}
