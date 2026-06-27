package com.corejava.Basics.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
public class demoArrayCopy {

    public static void main(String[] args) {

        // Approach 1
        String[] strFrom = {"New Delhi", "Mumbai", "Kolkata", "Chennai", "Hyderabad", "Bangalore"};
        String[] strTo = new String[strFrom.length];
        System.arraycopy(strFrom, 0, strTo, 0, 4);
        for (String city: strTo){
            IO.println(city);
        }

	// Approach 2: Copy by reference
        int [] even = {2, 4, 6, 8, 8, 10};
        int[] evenCopy = even;
        even [0] = 12;
        System.out.println(evenCopy[0]); //even and evenCopy points to same memory now.

	// Approach 3: Copy by value
        int[] copiedEven = Arrays.copyOf(even, even.length);
        copiedEven[0] = 20;
        System.out.println(even[0]);

        // Approach 4: ArrayList copy
        ArrayList<String> cities = new ArrayList<>();
        String[] strArray = {"New Delhi", "Mumbai", "Kolkata", "Chennai", "Hyderabad", "Bangalore"};
        for(int i=0; i < strArray.length; i++) {
            cities.add(strArray[i]);
        }
        
        // Copy by reference
        ArrayList<String> copiedCity = cities; 
        cities.set(0, "Tokyo");
        for (int i=0; i < copiedCity.size(); i++) {
            System.out.printf("City %s\n", copiedCity.get(i));

        }

        // Copy by value
        var copiedCities = new ArrayList<>(copiedCity); 
        copiedCity.set(2, "Peong Yong");
        for (int i=0; i < copiedCities.size(); i++) {
            System.out.printf("City %s\n", copiedCities.get(i));

        }

        for (int i=0; i < copiedCity.size(); i++) {
            System.out.printf("City %s\n", copiedCity.get(i));

        }

    }

}
