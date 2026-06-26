package com.corejava.Basics.Numbers;

public class NumberFmt {
    public static void main(String[] args) {
        
        int iv = 1000;
        float fv =  75.2f;
        double dv = 88000.22d;
        String str = "Kharagpur";

        System.out.format("""
                          The value of the%n integer variable is %d%n float is %f%n double is %f%n String is %s%n
                          """, iv, fv, dv, str);


    }
    
}
