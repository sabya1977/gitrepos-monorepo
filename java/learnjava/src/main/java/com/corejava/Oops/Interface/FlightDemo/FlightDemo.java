package com.corejava.Oops.Interface.FlightDemo;

import java.util.ArrayList;
import java.util.Collections;

public class FlightDemo {

    public static void main(String[] args) {
        Flight LondonToDurban = new Flight(1200, "London", "Durban", 50);
        Flight BeijingToNewDelhi = new Flight(5000, "Beijing", "New Delhi", 300);
        Flight MoscowToPyongyong = new Flight(8000, "Moscow", "Pyongyong", 97);
        Flight MoscowToPBeijing = new Flight(8500, "Moscow", "Beijing", 96);
        Flight MoscowToPBerlin = new Flight(9000, "Moscow", "Berlin", 127);
        Flight NewYorkToLondon = new Flight(6500, "New York", "London", 100);
        Flight NewYorkToParis = new Flight(7500, "New York", "Paris", 80);
        Flight HavanaToTehran = new Flight(5500, "Havana", "Tehran", 120);

        ArrayList <Flight> ListofFlights = new ArrayList<>();
        
        ListofFlights.add(MoscowToPBerlin);
        ListofFlights.add(MoscowToPBeijing);
        ListofFlights.add(MoscowToPyongyong);
        ListofFlights.add(NewYorkToParis);
        ListofFlights.add(NewYorkToLondon);
        ListofFlights.add(HavanaToTehran);
        ListofFlights.add(BeijingToNewDelhi);
        ListofFlights.add(LondonToDurban);

        System.out.println("=====================================Before Sort=====================================");
    
        for (Flight flight: ListofFlights) {
            System.out.println(flight);
        }

        Collections.sort(ListofFlights);
        System.out.println("=====================================After Sort=====================================");
    
        for (Flight flight: ListofFlights) {
            System.out.println(flight);
        }

    }
}
