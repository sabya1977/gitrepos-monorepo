package com.corejava.Oops.Statics;
// With import static, you do not have to use Math.PI and Math.pow(). 
// you can use PI and pow independently instead.
import static java.lang.Math.PI; 
import static java.lang.Math.pow; 

public class StaticImportDemo {
    public static void main(String[] args) {
        float r =2.4f;
        double area = 4 * PI * pow (r, 2);
        System.out.printf("Surface area of sphere with radius %f is %f%n", r, area);
    }
}
