package com.corejava.Basics.Arrays;

public class demoArrayReturn {

    public String[] getCapital (String[] argcnty) {
        if (argcnty.length == 0) {
            return new String[0];
        }
        String [] capital = new String [argcnty.length];
        int index = 0;
        for (String country: argcnty) {
            capital[index] = 
                    switch (country) {
                        case "India" -> {yield "New Delhi";}
                        case "Bangladesh" -> {yield "Dhaka";}
                        case "Sri Lanka" -> {yield "Colombo";}
                        case "Nepal" -> {yield "Kathmandu";}
                        case "Bhutan" -> {yield "Thingpu";}
                        case "Afganisthan" -> {yield "Kabul";}
                        default -> { yield "Invalid country"; }
                    };
                    index = index + 1;
        }
        return capital;
    }    

    public static void main(String[] args) {

        String [] country = {"India", "Nepal", "Bhutan", "Bangladesh"};
        demoArrayReturn objArrayReturn = new demoArrayReturn();
        // we are creating an object of the class and make the method non-static
        String [] capital = objArrayReturn.getCapital (country); 
        for (String capt: capital) {
            System.out.println(capt);
        }
        
    }
}
