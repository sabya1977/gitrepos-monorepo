package com.corejava.Oops.NestedClass;

class Teacher {
    public void teachStudents() {
        System.out.println("I am teaching students");
    }
}

// class MathTeacher extends Teacher {
//     public void teachStudents() {
//         System.out.println("I am teaching Math students");
//     }
// }

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {

        Teacher teacher = new Teacher()
        {    // anonymous nested class
            @Override
            public void teachStudents () 
            {
               System.out.println("I am teaching Math students");
            }
        };
        teacher.teachStudents();        
    }    

}
