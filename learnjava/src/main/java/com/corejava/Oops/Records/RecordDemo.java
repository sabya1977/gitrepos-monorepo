package com.corejava.Oops.Records;

record Person(String name, int age, String email) {
    // Records can have custom constructors with validation
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
    
    // Records can have additional methods
    public boolean isAdult() {
        return age >= 18;
    }
    
    public String getDisplayName() {
        return name.toUpperCase();
    }
}

// Record for representing a point in 2D space
record Point(double x, double y) {
    // Static factory method
    public static Point origin() {
        return new Point(0, 0);
    }
    
    // Instance method to calculate distance from origin
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
    
    // Instance method to calculate distance between two points
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// Record for a book with nested records
record Author(String firstName, String lastName) {
    public String fullName() {
        return firstName + " " + lastName;
    }
}

record Book(String title, Author author, int pages, double price) {
    // Compact constructor with validation
    public Book {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be positive");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
    
    public boolean isExpensive() {
        return price > 50.0;
    }
}

public class RecordDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Records Examples ===\n");
        
        // Creating and using Person records
        Person person1 = new Person("John Doe", 25, "john@example.com");
        Person person2 = new Person("Jane Smith", 17, "jane@example.com");
        
        System.out.println("Person 1: " + person1);
        System.out.println("Name: " + person1.name());
        System.out.println("Age: " + person1.age());
        System.out.println("Email: " + person1.email());
        System.out.println("Display Name: " + person1.getDisplayName());
        System.out.println("Is Adult: " + person1.isAdult());
        System.out.println();
        
        System.out.println("Person 2: " + person2);
        System.out.println("Is Adult: " + person2.isAdult());
        System.out.println();
        
        // Creating and using Point records
        Point origin = Point.origin();
        Point point1 = new Point(3.0, 4.0);
        Point point2 = new Point(1.0, 1.0);
        
        System.out.println("Origin: " + origin);
        System.out.println("Point 1: " + point1);
        System.out.println("Point 1 distance from origin: " + point1.distanceFromOrigin());
        System.out.println("Distance between points: " + point1.distanceTo(point2));
        System.out.println();
        
        // Creating and using Book records with nested Author record
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", author, 328, 15.99);
        
        System.out.println("Book: " + book);
        System.out.println("Title: " + book.title());
        System.out.println("Author: " + book.author().fullName());
        System.out.println("Pages: " + book.pages());
        System.out.println("Price: $" + book.price());
        System.out.println("Is Expensive: " + book.isExpensive());
        System.out.println();
        
        // Demonstrating record equality and hashCode
        Person person3 = new Person("John Doe", 25, "john@example.com");
        System.out.println("person1.equals(person3): " + person1.equals(person3));
        System.out.println("person1.hashCode() == person3.hashCode(): " + 
                          (person1.hashCode() == person3.hashCode()));
        
        // Records are immutable - all fields are final
        System.out.println("\n=== Record Features ===");
        System.out.println("✓ Automatic constructor");
        System.out.println("✓ Automatic getter methods (name(), age(), email())");
        System.out.println("✓ Automatic equals(), hashCode(), and toString()");
        System.out.println("✓ Immutable by default (all fields are final)");
        System.out.println("✓ Can have custom methods and constructors");
        System.out.println("✓ Can implement interfaces");

    }
}
