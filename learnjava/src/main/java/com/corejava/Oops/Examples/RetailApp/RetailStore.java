package com.corejava.Oops.Examples.RetailApp;

public class RetailStore {
    
    private StoreKeeper storeKeeper;
    private String storeName;
    private String storeCity;
    private String storeFullAddress;

    public RetailStore () {
        this.storeName = "All Item Store";
        this.storeCity = "New York";
        this.storeFullAddress = "105 Down Street";
        String StoreKeeprName = "Naket Tim";
        this.storeKeeper = new StoreKeeper(StoreKeeprName);
    }

    public String getStoreName () {
        return this.storeName;
    }

    public String getStoreCity () {
        return this.storeCity;
    }

    public String getStoreFullAddress() {
        return this.storeFullAddress;
    }

    public StoreKeeper getStoreKeeper () {
        return this.storeKeeper;
    }

    public static void main(String[] args) {

        // Purchase items
        RetailStore sampleStore = new RetailStore();
        StoreKeeper storeKeeper = sampleStore.getStoreKeeper();
        Product product = new Product("Apple Macbook Pro", 160000);
        Supplier supplier = new Supplier("Apple Inc", "APL-Z09188");
        PurchaseOrder po = storeKeeper.createPurchaseOrder(product, supplier, 1);
        po.showPODetails();
        Shipment shipment = supplier.fulfillOrder(po);
        InventoryItem invItem = storeKeeper.createInventoryItem(shipment);
        invItem.showInventory();
        
        // Sell items
        Customer fred = new Customer("Fred", 500000);
        int qtyOrdered = 2;
        Order order = fred.createOrder(fred, product, qtyOrdered);
        if (fred.checkBalance(order)) {
            System.out.printf("Your currant wallet balance is %f\n", fred.getWalletBal());
            if (fred.executeOrder(fred, order, invItem)) {
                System.out.printf("Order Id %s successfully created\n", order.getOrderId());
            } 
            else 
            {  
                System.out.printf("Product %s is out of stock\n", product.getPname());
                System.exit(-4);
            }
        } else { System.exit(-4); }

        invItem.showInventory();
        System.out.printf("Your currant wallet balance is %f\n", fred.getWalletBal());


    }    
}
