package edu.corejava.records;

import java.util.Arrays;

public class EmprRecordDemo {

        public record Employee(

                        String id,
                        String name,
                        int salary,
                        String[] locations) {

                public String getOfficeLocation() {
                        if (locations.length == 1) {
                                return locations[0];
                        } else {
                                return locations[locations.length - 1];
                        }

                }
        }

        public static void main(String[] args) {

                String[] location = { "New Delhi" };
                Employee e1 = new Employee("201070", "Sabyasachi Mitra", 2000, location);
                System.out.println("Emp ID: " + e1.id() + ", " + "Name: " + e1.name() + ", " +
                                "Salary: " + e1.salary() + ", "
                                + "Office Location: " + e1.getOfficeLocation());
                Employee e1updatedEmployee = new Employee(e1.id(), e1.name(), 200000, location);
                System.out.println("Sabya got a raise: " + "New Salary: "
                                + e1updatedEmployee.salary());
                String[] newlocation = Arrays.copyOf(location, location.length + 1);
                newlocation[newlocation.length - 1] = "Hyderabad";
                Employee e2 = new Employee(e1updatedEmployee.id(), e1updatedEmployee.name(), e1updatedEmployee.salary(),
                                newlocation);
                System.out.println("Sabya's new office location: " + e2.getOfficeLocation());

        }
}