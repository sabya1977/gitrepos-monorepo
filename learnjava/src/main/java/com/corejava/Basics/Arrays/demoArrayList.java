package com.corejava.Basics.Arrays;
import java.util.ArrayList;

public class demoArrayList {

    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("Moscow");
        cities.add("Delhi");
        cities.add("Calcutta");
        cities.add("Bombay");
        for (int i=0; i < cities.size(); i++) {
            System.out.printf("City name: %s\n", cities.get(i));
        }
    }    
}
