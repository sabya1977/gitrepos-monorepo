package com.corejava.Basics.Numbers;

import java.util.Calendar;
import java.util.TimeZone;

public class Formatter {

    public static void main(String[] args) {
        int intvar = 678882;
        System.out.format("%07d%n", intvar);
        System.out.format("%+7d%n", intvar);
        System.out.format("%,+7d%n", intvar * -1);

        double pi = Math.PI;
        System.out.format("%f%n", pi);
        System.out.format("%.3f%n", pi);
        System.out.format("%10.3f%n", pi);

        Calendar tv = Calendar.getInstance();
        String timez = tv.getTimeZone().getDisplayName();
        System.out.println(timez);
        TimeZone tz = TimeZone.getTimeZone("IST");
        tv.setTimeZone(tz);
        System.out.format("%tdth %tB, %tY %tl:%tM %tp %n", tv, tv, tv, tv, tv, tv);
        System.out.format("%tD%n", tv);
    }
}
