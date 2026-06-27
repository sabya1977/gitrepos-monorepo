/**
* An Invoice class represents an invoice with
* line items for each part of the order.
* line items are represented by static inner class item
* Items are created and added to the invoice by Invoice
* method addItem.
*/
package com.corejava.Oops.NestedClass;

import java.util.ArrayList;

public class Invoice {
    public static class Item {
        private String description;
        private int quantity;
        private double UnitPrice;

        public Item (String desc, int qty, double price) {
            this.description = desc;
            this.quantity = qty;
            this.UnitPrice = price;
        }
        double getPrice () { return quantity * UnitPrice; }

        // public void removeItem () {
        //     items.remove(this) // Error: inner class is staic and accessing non-static items
        // }

    }
    private ArrayList <Item> items = new ArrayList<>();
    private final String InvoiceId;

    public void addItem (String desc, int qty, double price) {
        Item item = new Item(desc, qty, price);
        items.add(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Invoice (String InvoiceId) {
        this.InvoiceId = InvoiceId;
    }

    public double getTotal() {
        double total = 0.0;
        for (Item it : items) {
            total += it.getPrice();
        }
        return total;
    }

    public int getItemCount() {
        return items.size();
    }

    public void printInvoice() {
        System.out.println("Invoice ID: " + InvoiceId);
        System.out.printf("%-30s %5s %12s %12s%n", "Description", "Qty", "UnitPrice", "LineTotal");
        System.out.println("--------------------------------------------------------------------");
        for (Item it : items) {
            System.out.printf("%-30s %5d %12.2f %12.2f%n", it.description, it.quantity, it.UnitPrice, it.getPrice());
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%49s %12.2f%n", "Total:", getTotal());
    }
}
