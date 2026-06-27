package com.corejava.Oops.Examples.RetailApp;

public class Supplier {
    private String SupplierID;
    private String SupplierName;

    public Supplier (String SupplierName, String SupplierID) {
        this.SupplierName = SupplierName;
        this.SupplierID = SupplierID;
    }

    public Shipment fulfillOrder(PurchaseOrder po) {
        System.out.printf("Supplier %s is processing the PO# %s\n", this.SupplierName, 
                    po.getPurchaseOrderID());
        Shipment shipment = createShipment(po);
        dispatch(shipment, po);
        return shipment;
    }

    private Shipment createShipment (PurchaseOrder po) {
        return new Shipment(po, po.getRequestedQty());
    }

    private void dispatch(Shipment shipment, PurchaseOrder po) {
        System.out.printf("PO# %s is shipped. Tracking ID: %s\n", 
                            po.getPurchaseOrderID(), shipment.getTrackingNumber());
        shipment.setStatus("SHIPPED");
    }

    public String getSupplierID() {
        return this.SupplierID;
    }

    public String getSupplierName() {
        return  this.SupplierName;
    }

}
