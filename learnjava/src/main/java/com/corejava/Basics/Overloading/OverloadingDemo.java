package com.corejava.Basics.Overloading;

class Calculator {
    int add (int ... values) {
        
        int sum = 0;
        for (int v: values) {
            sum+=v;
        }
        return sum;
    }

    double add (double ... values) {
        double sum =0;
        for (double v: values) {
            sum += v;
        }
        return sum;
    }
}
public class OverloadingDemo {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.printf(" Integer summation %d%n", c.add(1, 2, 3, 5));
        System.out.printf(" Floating Point summation %f%n", c.add(1.5, 2.5, 3.6, 5));
    }

}
