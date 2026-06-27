public class Item {
    private String name;
    private int quantity;
    private String category;

    public String getName () {
        return name;
    }

    public int getQuantity (){
        return quantity;
    }

    public String getCategory () {
        return category;
    }

    public Item (String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

//    @Override
//    public String toString() {
//        return "Item Name: " + getName() + ", Category: " + getCategory() + ", Quantity: " + getQuantity();
//    }

    public String getAll() {
        return "Item Name: " + getName() + ", Category: " + getCategory() + ", Quantity: " + getQuantity();
    }
}

