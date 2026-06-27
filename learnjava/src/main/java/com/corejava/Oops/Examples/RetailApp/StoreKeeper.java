package com.corejava.Oops.Examples.RetailApp;

public class StoreKeeper {

    private String storeKeeperName;

    public StoreKeeper (String storeKeeperName) {
        this.storeKeeperName = storeKeeperName;
    }

    public PurchaseOrder createPurchaseOrder (Product product, Supplier supplier, 
                    int getRequestedQty) 
    {
        PurchaseOrder po = new PurchaseOrder(product, supplier, getRequestedQty);
        return po;
    }

    public InventoryItem createInventoryItem (Shipment shipment) {
        System.out.printf("Shipment - Tracking# %s is received\n", 
                                shipment.getTrackingNumber());
        PurchaseOrder po = shipment.getPurchaseOrder();
        Product product = po.getProduct();
        System.out.printf("Restocking Inventory for Product ID: %s\n", 
                                product.getPid());
        int qtyShipped = shipment.getQtyShipped();
        po.setPOStatus(true);
        return new InventoryItem(product, qtyShipped);
    }

    public String getStoreKeeperName() {
        return this.storeKeeperName;
    }
    
}
