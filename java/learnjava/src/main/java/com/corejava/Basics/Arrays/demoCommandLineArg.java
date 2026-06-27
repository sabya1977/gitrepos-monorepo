package com.corejava.Basics.Arrays;
public class demoCommandLineArg {
    public static void main (String[] arg) {
        if (arg.length == 0) {
            System.out.println("Error! no arguement passed");
            System.exit(-2);
        } else if (arg.length > 2) {
            System.out.println("Error! Invalid no. of arguements. Only 2 arg. allowed");
            System.exit(-2);            
        } else if (arg[0].equals("-h")) {
            System.out.printf("Say Hello to Life %s\n", arg[1]);
        } else if (arg[0].equals("-g")) {
            System.out.printf ("Say Good bye to Life %s\n", arg[1]);
        } else {
            System.out.println("Invalid first arguement - pass -h or -g");
        }
    }
}
