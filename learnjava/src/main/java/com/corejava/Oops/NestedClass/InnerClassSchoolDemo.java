package com.corejava.Oops.NestedClass;

import java.util.ArrayList;

public class InnerClassSchoolDemo {

        public static void main(String[] args) {

                School newschool = new School("Little Sisters");
                
                ArrayList<String> subjDeepak = new ArrayList<>();
                subjDeepak.add("Maths");
                subjDeepak.add("Physics");
                subjDeepak.add("Chemistry");
                subjDeepak.add("Computer Science");
                subjDeepak.add("English Language");
                School.Student deepak = newschool.new Student("AB98765", "Deepak", "12", subjDeepak);    

                newschool.enrStudent(deepak);

                ArrayList<String> subjRita = new ArrayList<>();
                subjRita.add("Biology");
                subjRita.add("Physics");
                subjRita.add("Chemistry");
                subjRita.add("Computer Science");
                subjRita.add("English Language");

                School.Student Rita = newschool.new Student("CD99705", "Rita", "12", subjRita);
                newschool.enrStudent(Rita);
                newschool.printSchool();
                deepak.takeTransfer();
                newschool.printSchool();
           
        }
}
