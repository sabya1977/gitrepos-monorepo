package com.corejava.Oops.NestedClass;

import java.util.ArrayList;

public class School {

    private String schoolname;

    public class Student {
        
        private String rollno;
        private String name;
        private String grade;
        private ArrayList<String> subjects;

        public Student (String roll, String name, String grade, ArrayList<String> subj) {
            this.rollno = roll;
            this.name = name;
            this.grade = grade;
            this.subjects = subj;
        }

        public void takeTransfer() {
            System.out.printf("%s is taking transfer from %sth grade%n",this.name, this.grade);
            students.remove(this); // a member function of Student cann access parent class member.
        }
    }

    private ArrayList<Student> students = new ArrayList<>();

    public void enrStudent (Student student) {
        students.add(student);
    }

    public School (String name) {
        this.schoolname = name;
    }    

    public void printSchool() {
        System.out.println("School name: " + this.schoolname);
        if (students == null || students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }
        for (Student s : students) {
            System.out.println("Student rollno: " + s.rollno);
            System.out.println("Name: " + s.name);
            System.out.println("Grade: " + s.grade);
            String subjStr;
            if (s.subjects == null || s.subjects.isEmpty()) {
                subjStr = "None";
            } else {
                subjStr = String.join(", ", s.subjects);
            }
            System.out.println("Subjects: " + subjStr);
            System.out.println("-----");
        }
    }

}
