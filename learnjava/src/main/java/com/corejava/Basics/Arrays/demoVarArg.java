package com.corejava.Basics.Arrays;

public class demoVarArg {

    public double average (double ... values) {

        double sum = 0;
        for (double v: values) {
            sum+=v;
        }
        return sum == 0 ? 0 : sum/values.length;

    }
    public static void main(String[] args) {
        demoVarArg objVarArg = new demoVarArg();
        var avg = objVarArg.average(1, 3.3, 4.5);
        System.out.printf("%.2f\n", avg);
        avg = objVarArg.average();
        System.out.printf("%.2f\n", avg);
    }    
}
