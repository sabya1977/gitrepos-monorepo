package com.corejava.Basics.Strings;

public class StringDemo {

    static public String charToStr (char[] chArray) {
        return new String(chArray);
    }

    static public float strToFloat (String ... pValues) {
            float fv = 0;
            for (String str: pValues){
                float ftemp = Float.valueOf(str); //Modern way
                ftemp = Float.parseFloat(str); // Efficient way
                fv+=ftemp;
            }
            return fv;
    }

    static public String numToStr (int iv) {
        return Integer.toString(iv);
    }
    public static void main(String[] args) {
        
        char[] pArray = { 'h', 'e', 'l', 'l', 'o', '.' };
        System.out.println(charToStr(pArray));
        
        System.out.println(strToFloat("23.5", "6.7"));
        System.out.println(numToStr(34));
        
    }

}
