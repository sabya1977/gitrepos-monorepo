package com.corejava.Oops.Examples.RetailApp;
import java.util.UUID;

public class PurchaseOrder {
    private Product product;
    private Supplier supplier;
    private int requstedQty;
    private String poNumber;
    private boolean isFulfilled = false;

    public PurchaseOrder (Product product, Supplier supplier, int requstedQty) {
        this.product = product;
        this.supplier = supplier;
        this.requstedQty = requstedQty;
        this.poNumber = UUID.randomUUID().toString().substring(0,8);
    }

    public Product getProduct () {
        return this.product;
    }

    public Supplier getSupplier () {
        return this.supplier;
    }

    public int getRequestedQty() {
        return this.requstedQty;
    }

    public String getPurchaseOrderID() {
        return this.poNumber;
    }

    public void setPOStatus (boolean isFulfilled) {
        this.isFulfilled = isFulfilled;
    }

    public void showPODetails() {
        System.out.printf("Purchase Order# %s to the Supplier# %s for the Product# %s of the Quantity %d is placed\n", 
                        this.poNumber, supplier.getSupplierName(), product.getPname(), this.requstedQty);
    }
}
