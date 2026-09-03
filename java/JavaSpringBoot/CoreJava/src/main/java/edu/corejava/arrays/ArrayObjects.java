package edu.corejava.arrays;

import java.util.Arrays;

public class ArrayObjects {

    public record Student(
            String rollno,
            String name,
            String[] subjects,
            int[] testmarks) {

        public Student {
            subjects = subjects.clone();
            testmarks = testmarks.clone();
        }

        @Override
        public int[] testmarks() {
            return testmarks.clone();
        }

        public String getMarks() {
            return Arrays.toString(testmarks);
        }

        public String getSubjects() {
            return Arrays.toString(subjects);
        }
    }

    public static void main(String[] args) {

        Student[] students = new Student[2];
        String[] subjects = { "Mathematics", "Physics", "Chemistry", "English" };
        int[] marks = new int[4];
        marks[0] = 20;
        marks[1] = 15;
        marks[2] = 18;
        marks[3] = 16;
        students[0] = new Student("789666", "Mohd. Azahar", subjects, marks);
        subjects[0] = "Biology";
        marks[0] = 19;
        students[1] = new Student("789555", "Johan Matt", subjects, marks);
        students[1].testmarks()[0] = 91;

        for (Student student : students) {
            System.out.println("Roll: " + student.rollno() + ", " + "Name: " + student.name()
                    + ", " + "Subjects: " + student.getSubjects()
                    + ", " + "Marks: " + student.getMarks());
        }

    }

}
