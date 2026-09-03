package edu.corejava.arrays;

public class JaggedArray {

    public static void main(String[] args) {

        // each row has different size. Number of rows fixed.
        // allocate array with fixed number of rows (3 in this case)
        int[][] JaggedArray = new int[3][];
        // for each row allocate a different number of columns
        JaggedArray[0] = new int[1];
        JaggedArray[1] = new int[2];
        JaggedArray[2] = new int[3];

        JaggedArray[0][0] = 10;
        JaggedArray[1][0] = 20;
        JaggedArray[1][1] = 30;
        JaggedArray[2][0] = 40;
        JaggedArray[2][1] = 50;
        JaggedArray[2][2] = 60;

        for (int i = 0; i < JaggedArray.length; i++) {
            for (int j = 0; j < JaggedArray[i].length; j++) {
                System.out.println(JaggedArray[i][j]);
            }
        }
    }

}
