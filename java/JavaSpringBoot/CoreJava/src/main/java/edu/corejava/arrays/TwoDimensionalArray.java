package edu.corejava.arrays;

public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] twodmatrix = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        for (int x = 0; x < twodmatrix.length; x++) {
            for (int y = 0; y < twodmatrix[x].length; y++) {
                System.out.println(twodmatrix[x][y]);
            }
        }

        int sum = 0;

        for (int x = 0; x < twodmatrix.length; x++) {
            for (int y = 0; y < twodmatrix[x].length; y++) {
                sum += twodmatrix[x][y];
            }
        }
        System.out.println("Sum of Two dimensional matrix: " + sum);
    }
}
