package com.corejava.Basics.Arrays;

public class DemoReferenceType {

    public static void main(String[] args) {
        
        char [] greet = {'h', 'e', 'l', 'l', 'o'};
        charArray ch = new charArray(greet);
        ch.showArray (greet);
        ch.changeArrays(greet);
        ch.showArray (greet);
    }
} 
