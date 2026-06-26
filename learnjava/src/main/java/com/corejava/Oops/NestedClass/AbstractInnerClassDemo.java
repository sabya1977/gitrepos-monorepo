package com.corejava.Oops.NestedClass;

// abstract outer class
abstract class Teacher {
    public void teachStudents() {
        System.out.println("I am teaching students");
    }
}

public class AbstractInnerClassDemo {
    public static void main(String[] args) {     
        // here we create the object of the annonymous Inner class, not Abstract outer class.
        Teacher t = new Teacher() {
            // teachStudents () is a method of annonymous Inner class overriding Abstract outer class.
            public void teachStudents () {
                System.out.println("I am teaching English language");
            }
        };
        t.teachStudents();
      }
}
