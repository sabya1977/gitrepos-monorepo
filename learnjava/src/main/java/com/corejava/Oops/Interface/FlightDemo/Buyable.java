package com.corejava.Oops.Interface.FlightDemo;

import java.util.ArrayList;
import java.util.List;

public interface Buyable {
    
    public static final List<String> SOURCE_CITY = new ArrayList<>();

    double price ();

    public static void setSourceCity(String city) {
        SOURCE_CITY.add("London");
    }
}
