package com.corejava.Oops.NestedClass;

public class StaticInnerClassDemo {
    public static void main(String[] args) {
        Invoice invoice = new Invoice ("ABH-99888");
        invoice.addItem("Blackwell Toaster", 2, 19.95);
        invoice.addItem("Acme Kettle", 1, 34.50);
        invoice.addItem("Platinum Mixer", 3, 89.99);
        Invoice.Item item = new Invoice.Item("Gillete Razor", 1, 23.99);
        invoice.addItem(item);

        invoice.printInvoice();
        
    }
}
