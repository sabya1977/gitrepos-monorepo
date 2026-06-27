package com.corejava.Oops.Examples.RetailApp;
import java.util.UUID;

public class Customer {
    private String customerID;
    private String customerName;
    private double walletBal;

    public Customer (String customerName, double walletBal) {
        this.customerID = UUID.randomUUID().toString().substring(0, 5);
        this.customerName = customerName;
        this.walletBal = walletBal;
    }

    public String getCustomerName() {
        return customerName;        
    }

    public String getCustomerID () {
        return customerID;
    }

    public double getWalletBal () {
        return this.walletBal;
    }

    public Order createOrder (Customer customer, Product product, int qtyOrdered) {
        return new Order (this, product, qtyOrdered);
    }

    public boolean checkBalance (Order order) {
        double price = order.getProduct().getPrice();
        double totalPrice = price * order.qtyOrdered();
        
        if (order.getCustomer().getWalletBal() + (totalPrice*-1) < 0) {
            System.out.println("Dear customer, you don't have enough balance!");
            return false;
        } else { return true; }      
    }
    
    public boolean executeOrder (Customer customer, Order order, InventoryItem invItem) 
        {          
            boolean retrunCode = invItem.adjustStock(order.qtyOrdered());
            if (retrunCode) { 
                double price = order.getProduct().getPrice();
                double totalPrice = price * order.qtyOrdered();
                payment(totalPrice);
                return true;
            } else { return false; }
        }
        
    private void payment(double totalPrice) {
        this.walletBal = this.walletBal - totalPrice;
        System.out.println("Payment successful!");
    }
  
}
