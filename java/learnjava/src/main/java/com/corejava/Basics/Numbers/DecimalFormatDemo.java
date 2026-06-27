package com.corejava.Basics.Numbers;
import java.text.*;
import java.util.Locale;

public class DecimalFormatDemo {

    static public void formatConvert (String fmt, double value) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(currency.format(value)); 
        if (fmt != null) {
            DecimalFormat df = new DecimalFormat(fmt);
            String output = df.format(value);
            IO.println(output);
        }
        
    }

    public static void main(String[] args) {
        formatConvert(null, 823456.7);
        formatConvert("$###,###.###", 123456.789);        
    }

}
