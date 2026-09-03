package edu.corejava.encapsulation;

class Human {

    private String citizenID;
    private String Name;
    private String City;

    void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    void setName(String name) {
        this.Name = name;
    }

    void setCity(String city) {
        this.City = city;
    }

    Human(String citizenID, String name, String city) {
        this.citizenID = citizenID;
        this.Name = name;
        this.City = city;
    }

    String getCitizenID() {
        return this.citizenID;
    }

    String getName() {
        return Name;
    }

    String getCity() {
        return City;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {

        Human alien = new Human("101010", "Thomas", "London");

        System.out.println("Citizen ID: " + alien.getCitizenID() + ", " +
                "Name: " + alien.getName() + ", " + "City: " + alien.getCity());

        alien.setCity("New York");

        System.out.println("Citizen ID: " + alien.getCitizenID() + ", " +
                "Name: " + alien.getName() + ", " + "City: " + alien.getCity());

    }
}
