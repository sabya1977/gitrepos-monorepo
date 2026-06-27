package com.corejava.Basics.Arrays;
import java.util.Arrays;

class demoArray {
    public static void main (String[] arg) {
        int[] monthArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] monthStrings = new String[12];

        for (int i=0; i < 12; i++) {
            if (monthArray[i] == 1) {
                monthStrings [i] = "Janurary";
            } else if (monthArray[i] == 2) {
                monthStrings [i] = "February";
            } else if (monthArray[i] == 3) {
                monthStrings [i] = "March";
            } else if (monthArray[i] == 4) { 
                 monthStrings [i] = "April";
            } else if (monthArray[i] == 5) {
                 monthStrings [i] = "May";
            } else if (monthArray[i] == 6) {
                monthStrings [i] = "June";
            } else if (monthArray[i] == 7) {
                monthStrings [i] = "July";
            } else if (monthArray[i] == 8) {
                monthStrings [i] = "August";
            } else if (monthArray[i] == 9) {
                monthStrings [i] = "September";
            } else if (monthArray[i] == 10) {
                monthStrings [i] = "October";
            } else if (monthArray[i] == 11) {
                monthStrings [i] = "November";
            } else if (monthArray[i] == 12) {
                monthStrings [i] = "December";
            }
        }

        int x = 0;
        while (x < monthStrings.length ) {
           System.out.printf("Month %d: %s\n", x+1, monthStrings[x] );
           x++;
           }
    
    // multi dimensional array

       // matrix multiplication
        int[][] matrix = { {10,10,10}, {20,20,30} };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * 2;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
        }

        // String multi dimensional matrix

        String [][] subjects = { {"Mathematics", "Physics", "Chemistry"},
                                 {"English Literature", "Philosophy", "Life Sciences"},
                                 {"Geography", "Medicine", "Engoneering"} 
                               };
        for (int i=0; i < subjects.length; i++) {
            for (int j = 0; j < subjects[i].length; j++) {
                System.out.printf("Subject %d %s\n", i+1, subjects[i][j]);
            }
        }
        // try different for loops for 2-dimensional array
        for (String[] str: subjects) {
            for (String sub: str)
            System.out.println(sub);
        }

        // Calculate sum, average, min, max, sort with array of values
        int[] numArray = {1, 100, 20, 301, 5, 20, 70, 15, 9, 2};
        int sum = 0;
        int max = numArray[0];
        int min = numArray[0];
        int avg = 0;

        // derive max value of the array
        for (int i = 0; i < numArray.length; i++) {
            if (max < numArray[i]) {
                max = numArray[i];
            }
        }
        System.out.printf("Max value is %d\n", max);

        // derive min value of the array
        for (int i = 0; i < numArray.length; i++) {
            if (min > numArray[i]) {
                min = numArray[i];
            }            
        }
        System.out.printf("Min value is %d\n", min);

        int[] moreNumbers = {10, 20, 30, 40, 50, 60};
        int total =0;
        for (int num: moreNumbers) {
            total = total + num;
        }
        IO.println("Array: " + Arrays.toString(moreNumbers));
        System.out.printf("Total is: %d\n", total);          
      }     
   }
