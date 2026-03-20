package com.corejava.Oops.Examples.RetailApp;

public class InventoryItem {

    private Product product;
    private int qtyStock;

     { // initialization block - gets executed before constructor
        qtyStock = 0;
     }
    public InventoryItem(Product product, int qtyShipped) {
        this.product = product;
        this.qtyStock = this.qtyStock + qtyShipped;
    }

    public boolean adjustStock (int stock) {
        if (this.qtyStock - stock < 0) {
            return false;
        } else {
            this.qtyStock = this.qtyStock - stock;
        }

        return true;
    }

    public void showInventory() {
        System.out.printf("Product %s has %d stock\n", 
                    product.getPname(), this.qtyStock );
    }

    public int getQtyStock () {
        return this.qtyStock;
    }

    public Product getProduct () {
        return this.product;
    }


}
