package com.corejava.Oops.Interface.InterfaceVarDemo;

class NameClass1 implements MyInterface {

    public void addNames () {
        MyInterface.NAMES.add("Siraj");
        MyInterface.NAMES.add("Smith");
        MyInterface.NAMES.add("Tarik");
        MyInterface.NAMES.add("Tamal");
    }
    public void showNames () {
        for (String name: MyInterface.NAMES) {
            System.out.println(name);
        }
    }

}

class NameClass2 implements  MyInterface {
    public void addNames () {

        MyInterface.NAMES.clear();
        MyInterface.NAMES.add("London");
        MyInterface.NAMES.add("Tehran");
        MyInterface.NAMES.add("Kolkata");
        MyInterface.NAMES.add("Hanoi");
    }

     public void showNames () {
        for (String name: MyInterface.NAMES) {
            System.out.println(name);
        }
    }
}
public class InterfaceVarDemo {

    public static void main(String[] args) {
        NameClass1 nc1 = new NameClass1();
        NameClass2 nc2 = new NameClass2();

        nc1.addNames();
        System.out.println("Name Class1 Names");
        nc1.showNames();
        nc2.addNames();
        System.out.println("Name Class1 Names after Name Class2 updates NAMES");
        nc1.showNames(); // this will show values added by NameClass1 + Values added by NameClass2

    }

}
