package com.corejava.Oops.Examples.RetailApp;
import java.util.UUID;

public class Shipment {
    private String trackingNumber;
    private PurchaseOrder po;
    private int qtyShipped;
    private String status;

    public Shipment (PurchaseOrder po, int qtyShipped) {
        this.trackingNumber = UUID.randomUUID().toString().substring(0,8);
        this.po = po;
        this.qtyShipped = qtyShipped;
        this.status = "Ready to Deliver";
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public PurchaseOrder getPurchaseOrder () {
        return this.po;
    }

    public int getQtyShipped() {
        return this.qtyShipped;
    }
}
