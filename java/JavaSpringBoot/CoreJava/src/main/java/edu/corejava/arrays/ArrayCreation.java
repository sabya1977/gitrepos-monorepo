package edu.corejava.arrays;

public class ArrayCreation {

    public static void main(String[] args) {
        int[] scores = new int[2];
        scores[0] = 10;
        scores[1] = 10;
        String[] fruitsString = { "Apple", "Banana", "Cherry" };

        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }

}
