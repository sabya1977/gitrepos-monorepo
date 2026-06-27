package com.corejava.Enum;

import java.util.ArrayList;

enum bookType {
    Fiction, NonFiction, Text, StoryBook, Language, Classics, ScienceFiction
}

class Book {

    private String title;
    private bookType booktype;

    public Book(String title, bookType bt) {
        this.title = title;
        this.booktype = bt;
    }

    public String getTitle() {
        return title;
    }

    public bookType getBookType() {
        return booktype;
    }
}


public class EnumDemo {

    public static void main(String[] args) {

        Book bObj1 = new Book("Economic History", bookType.NonFiction);
        Book bObj2 = new Book("Alice in Wonlderland", bookType.StoryBook);
        Book bObj3 = new Book("Oxford Phrasal Verbs", bookType.Language);
        Book bObj4 = new Book("Mathematics for Adults", bookType.Text);
        Book bObj5 = new Book("Six Easy Pieces", bookType.ScienceFiction);
        Book bObj6 = new Book("Republic", bookType.Classics);

        ArrayList<Book> ListofBooks = new ArrayList<>();

        ListofBooks.add(bObj1);
        ListofBooks.add(bObj2);
        ListofBooks.add(bObj3);
        ListofBooks.add(bObj4);
        ListofBooks.add(bObj5);
        ListofBooks.add(bObj6);

        for (Book b: ListofBooks) {
            System.out.println("Book Title: " + b.getTitle() + " Book Type: " + b.getBookType());
        }

        for (Book b: ListofBooks) {
            if (b.getBookType() == bookType.Fiction) {
                System.out.println("Title " + b.getTitle() + " is fiction");
            }
            else if (b.getBookType() == bookType.NonFiction) {
                System.out.println("Title " + b.getTitle() + " is Non fiction");
            }
            else if (b.getBookType() == bookType.Text) {
                System.out.println("Title " + b.getTitle() + " is Text Book");
            }
            else if (b.getBookType() == bookType.StoryBook) {
                System.out.println("Title " + b.getTitle() + " is Story Book");
            }
        }
    } 
}
