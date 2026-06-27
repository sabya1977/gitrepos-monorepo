package com.corejava.Oops.AbstractClass;

abstract class Phone {
    
    abstract public void call();
    abstract public void sendEmail();

    public void playMusic() {
        System.out.println("Playing music");
    }
}

class Samsung extends Phone {

    @Override
    public void call () {
        System.out.println("Calling from my Samsung phone");
    }

    @Override
    public void sendEmail () {
        System.out.println("Email sent from my Samsung phone");
    }
}

class Apple extends Phone {

    @Override
    public void call () {
        System.out.println("Calling from my Apple phone");
    }

    @Override
    public void sendEmail () {
        System.out.println("Email sent from my Apple phone");
    }
}

public class AbstractClassDemo {

    public static void main(String[] args) {
        Phone p1 = new Samsung();
        p1.call();
        p1.sendEmail();
        p1.playMusic();

        Phone p2 = new Apple();
        p2.call();
        p2.sendEmail();
        p2.playMusic();
    }
}
