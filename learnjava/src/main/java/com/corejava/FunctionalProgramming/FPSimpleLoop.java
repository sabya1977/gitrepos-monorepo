package com.corejava.FunctionalProgramming;
import java.util.stream.IntStream;

public class FPSimpleLoop {
    
    public static void main(String[] args) {
        
        // converting simple loop
        for (int i=0; i<5; i++) {
        IO.println(i);
        }

        IntStream.range(0,5).forEach(IO::println);

    } 
}
