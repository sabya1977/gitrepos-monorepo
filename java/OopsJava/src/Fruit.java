public class Fruit extends Item {
    private String type;

    public Fruit (String name, int quantity, String category, String type) {
        super(name, quantity, category);
        this.type = type;
    }

    public String getType () {
        return type;
    }

//    @Override
//    public String toString() {
//        return "Item Name: " + getName() + ", Category: " + getCategory() + ", Type: " + getType() + ", Qty: " + getQuantity();
//    }

    @Override
    public String getAll() {
        return "Item Name: " + getName() + ", Category: " + getCategory() + ", Type: " + getType() + ", Qty: " + getQuantity();
    }
}
