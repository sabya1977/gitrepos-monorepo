package edu.corejava.strings;

public class StringDemo {

    public static void main(String[] args) {

        // splitting a string
        String technologies = "Java,Spring,Oracle";
        String[] values = technologies.split(",");
        for (String value : values) {
            System.out.println(value);
        }

        String text = """
                SELECT employee_id,
                       employee_name
                FROM employees
                WHERE department_id = 10
                """;
        System.out.println(text);

        StringBuffer buffer = new StringBuffer("Sabyasachi");
        buffer.append(" Mitra");
        System.out.println(buffer);
        buffer.insert(0, "India ");
        System.out.println(buffer);

    }
}
