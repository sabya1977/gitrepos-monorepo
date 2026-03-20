package com.corejava.Oops.Examples.RetailApp;
import java.util.UUID;

public class Order {
    
    private String orderId;
    private Customer customer;
    private Product product;
    private int qtyOrdered;

    public Order (Customer customer, Product product, int qtyOrdered) {
        this.orderId = UUID.randomUUID().toString().substring(0, 5);
        this.customer = customer;
        this.product = product;
        this.qtyOrdered = qtyOrdered;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public Customer getCustomer () {
        return this.customer;
    }

    public Product getProduct () {
        return this.product;
    }

    public int qtyOrdered () {
        return this.qtyOrdered;
    }

}
