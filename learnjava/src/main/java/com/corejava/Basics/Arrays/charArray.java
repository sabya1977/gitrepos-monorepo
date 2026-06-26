package com.corejava.Basics.Arrays;

public class charArray {

    private char [] ch;

    public void changeArrays (char[] cuss) {
        cuss[4] = '!';
    }

    public charArray (char [] ch) {
        this.ch = ch;
    }

    public void showArray(char [] cuss)  {
        for (char x: cuss) {
            System.out.printf("%c", x);
        }
        System.out.println();
    }

}
