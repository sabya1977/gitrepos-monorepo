package edu.corejava.arrays;

public class ThreeDimensionalArray {

    public static void main(String[] args) {
        int x = 10;
        int[][][] ThreeDimensionalArray = new int[1][2][3];
        // System.out.println(ThreeDimensionalArray[0][1].length);
        for (int i = 0; i < ThreeDimensionalArray.length; i++) {
            for (int j = 0; j < ThreeDimensionalArray[i].length; j++) {
                for (int k = 0; k < ThreeDimensionalArray[i][j].length; k++) {
                    ThreeDimensionalArray[i][j][k] = x;
                    x = x * 10;
                }
            }
        }

        for (int i = 0; i < ThreeDimensionalArray.length; i++) {
            for (int j = 0; j < ThreeDimensionalArray[i].length; j++) {
                for (int k = 0; k < ThreeDimensionalArray[i][j].length; k++) {
                    System.out.println(ThreeDimensionalArray[i][j][k]);
                }
            }
        }
    }
}
