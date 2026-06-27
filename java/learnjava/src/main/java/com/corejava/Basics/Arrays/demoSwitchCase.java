package com.corejava.Basics.Arrays;
import java.util.ArrayList;

class demoSwitchCase {
        
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
        int month = 6;
        ArrayList<String> monthname = new ArrayList<>();
        switch(month) {
            case 1: 
                monthname.add("January");
                break;
            case 2: 
                monthname.add("Februray");
                break;
            case 3: 
                monthname.add("March");
                break;
            case 4: 
                monthname.add("April");
                break;
            case 5: 
                monthname.add("May");
                break;
            case 6: 
                monthname.add("June");
                break;
            case 7: 
                monthname.add("July");
                break;
            case 8: 
                monthname.add("August");
                break;
            case 9: 
                monthname.add("Septembor");
                break;
            case 10: 
                monthname.add("Octobor");
                break;
            case 11: 
                monthname.add("Novembor");
                break;
            case 12: 
                monthname.add("Decembor");
                break;
            default: break;
        }
        IO.println(monthname);

        int numDays = 0;
        int year = 2026;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: 
            case 10: case 12:
                numDays = 31;
                break;
            case 4: case 6: case 9: case 11: 
                numDays = 30;
                break;
            case 2: 
                if (chkLeapYear(year)) {
                    numDays = 29;
                }
                numDays = 28;
                break;
            default: 
                IO.println("Invalid month");
                break;
            }
            
            String monthLabel = switch(month) {
                case 1 -> { yield "January";}
                case 2 -> { yield "February"; }
                case 3 -> { yield "March"; }
                case 4 -> { yield "April"; } 
                case 5 -> { yield "May"; }
                case 6 -> { yield "June"; }
                case 7 -> { yield "July"; }
                case 8 -> { yield "August"; }
                case 9 -> { yield "Sepember"; }
                case 10 -> { yield "October"; }
                case 11 -> { yield "November"; }
                case 12 -> { yield "December"; }
                default -> { yield "Invalid Month"; }
            };
                
            System.out.printf("Year: %d\n", year);
            System.out.printf("Month name: %s\n", monthLabel);
            System.out.printf("Number of days: %d\n", numDays);

        }
    }