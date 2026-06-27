package com.corejava.Oops.Records;

// Demonstration of the differences between Records and Normal Classes

// ================== NORMAL CLASS APPROACH ==================
class PersonClass {
    // Fields must be explicitly declared
    private final String name;
    private final int age;
    private final String email;
    
    // Constructor must be explicitly written
    public PersonClass(String name, int age, String email) {
        // Validation logic
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Getters must be explicitly written
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // equals() method must be explicitly written
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonClass that = (PersonClass) obj;
        return age == that.age &&
               name.equals(that.name) &&
               email.equals(that.email);
    }
    
    // hashCode() method must be explicitly written
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + email.hashCode();
        return result;
    }
    
    // toString() method must be explicitly written
    @Override
    public String toString() {
        return "PersonClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
    
    // Custom methods
    public boolean isAdult() {
        return age >= 18;
    }
    
    public String getDisplayName() {
        return name.toUpperCase();
    }
}

// ================== RECORD APPROACH ==================
record PersonRecord(String name, int age, String email) {
    // Compact constructor with validation (much shorter!)
    public PersonRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
    
    // Custom methods (same as class)
    public boolean isAdult() {
        return age >= 18;
    }
    
    public String getDisplayName() {
        return name.toUpperCase();
    }
}

public class RecordVsClass {
    // ================== COMPARISON DEMO ==================
    public static void main(String[] args) {
        System.out.println("=== RECORD vs NORMAL CLASS COMPARISON ===\n");
        
        // Creating instances
        PersonClass personClass = new PersonClass("John Doe", 25, "john@example.com");
        PersonRecord personRecord = new PersonRecord("John Doe", 25, "john@example.com");
        
        System.out.println("1. CREATION AND BASIC USAGE:");
        System.out.println("Class:  " + personClass);
        System.out.println("Record: " + personRecord);
        System.out.println();
        
        System.out.println("2. ACCESSING DATA:");
        System.out.println("Class getter:  personClass.getName() = " + personClass.getName());
        System.out.println("Record getter: personRecord.name() = " + personRecord.name());
        System.out.println();
        
        System.out.println("3. CUSTOM METHODS (same functionality):");
        System.out.println("Class:  personClass.isAdult() = " + personClass.isAdult());
        System.out.println("Record: personRecord.isAdult() = " + personRecord.isAdult());
        System.out.println();
        
        System.out.println("4. EQUALITY AND HASHCODE:");
        PersonClass personClass2 = new PersonClass("John Doe", 25, "john@example.com");
        PersonRecord personRecord2 = new PersonRecord("John Doe", 25, "john@example.com");
        
        System.out.println("Class equality:  " + personClass.equals(personClass2));
        System.out.println("Record equality: " + personRecord.equals(personRecord2));
        System.out.println("Class hashCode:  " + personClass.hashCode());
        System.out.println("Record hashCode: " + personRecord.hashCode());
        System.out.println();
        
        System.out.println("=== KEY DIFFERENCES ===");
        printDifferences();
        
        System.out.println("\n=== LINES OF CODE COMPARISON ===");
        printLinesComparison();
        
        System.out.println("\n=== WHEN TO USE WHICH ===");
        printUsageGuidance();
    }
    
    static void printDifferences() {
        System.out.println("+---------------------+---------------------+---------------------+");
        System.out.println("| Aspect              | Normal Class        | Record              |");
        System.out.println("+---------------------+---------------------+---------------------+");
        System.out.println("| Purpose             | General-purpose     | Data containers     |");
        System.out.println("| Mutability          | Can be mutable      | Always immutable    |");
        System.out.println("| Fields              | Manually declared   | Auto from params    |");
        System.out.println("| Constructor         | Manual              | Auto-generated      |");
        System.out.println("| Getters             | Manual (getName())  | Auto (name())       |");
        System.out.println("| equals()            | Manual              | Auto-generated      |");
        System.out.println("| hashCode()          | Manual              | Auto-generated      |");
        System.out.println("| toString()          | Manual              | Auto-generated      |");
        System.out.println("| Inheritance         | Can extend classes  | Cannot extend       |");
        System.out.println("| Can be extended     | Yes (unless final)  | No (implicitly final)|");
        System.out.println("| Interfaces          | Can implement       | Can implement       |");
        System.out.println("| Static methods      | Yes                 | Yes                 |");
        System.out.println("| Instance methods    | Yes                 | Yes                 |");
        System.out.println("| Nested classes      | Yes                 | Yes                 |");
        System.out.println("| Annotations         | Yes                 | Yes                 |");
        System.out.println("+---------------------+---------------------+---------------------+");
    }
    
    static void printLinesComparison() {
        System.out.println("For the same Person functionality:");
        System.out.println("• Normal Class: ~65 lines of code");
        System.out.println("• Record:       ~15 lines of code");
        System.out.println("• Reduction:    ~77% less code!");
        System.out.println();
        System.out.println("What Records automatically provide:");
        System.out.println("✓ Constructor");
        System.out.println("✓ Field declarations (private final)");
        System.out.println("✓ Getter methods");
        System.out.println("✓ equals() method");
        System.out.println("✓ hashCode() method");
        System.out.println("✓ toString() method");
    }
    
    static void printUsageGuidance() {
        System.out.println("USE RECORDS WHEN:");
        System.out.println("• You need immutable data containers");
        System.out.println("• Modeling DTOs (Data Transfer Objects)");
        System.out.println("• Representing tuples or pairs");
        System.out.println("• API responses/requests");
        System.out.println("• Configuration objects");
        System.out.println("• Value objects in Domain Driven Design");
        System.out.println();
        System.out.println("USE NORMAL CLASSES WHEN:");
        System.out.println("• You need mutable state");
        System.out.println("• Complex business logic");
        System.out.println("• Need inheritance hierarchies");
        System.out.println("• Require custom field access control");
        System.out.println("• Building frameworks or libraries");
        System.out.println("• Need lazy initialization");
    }
}
