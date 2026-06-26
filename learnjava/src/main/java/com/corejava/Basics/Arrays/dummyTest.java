package com.corejava.Basics.Arrays;
public class dummyTest {
    public static boolean chkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
            }
            else {
                return true;
            }
        }
        return false;
    }        
     public static void main (String[] arg) {

        for (int i = 1900; i <=2026; i++) {

            if (chkLeapYear(i)) {
                System.out.printf("%d is a Leap year\n", i);
            }
            // else {System.out.printf("%d is not a Leap Year\n", i);}

        }

        

     }
}
