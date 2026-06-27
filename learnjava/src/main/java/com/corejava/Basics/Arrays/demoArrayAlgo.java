package com.corejava.Basics.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class demoArrayAlgo {
    public static void main (String[] arg) {
        int[] numbers = new int[10];
        Arrays.fill(numbers, 0);

        ArrayList<Integer> arrayNum = new ArrayList<Integer>();
        Collections.fill(arrayNum, 0);
        arrayNum.add(1000);
        arrayNum.add(3);
        arrayNum.add(2);
        arrayNum.add(14);
        arrayNum.add(20);
        arrayNum.add(100);
        arrayNum.add(150);

        for (int i=0; i < arrayNum.size(); i++) {
            System.out.println(arrayNum.get(i));
        }
        Collections.sort(arrayNum);
        System.out.println("After Sorting");
        for (int i=0; i < arrayNum.size(); i++) {
            System.out.println(arrayNum.get(i));
        }
        


    }
}
