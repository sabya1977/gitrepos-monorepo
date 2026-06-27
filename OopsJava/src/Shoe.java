public class Shoe extends Item {
    private String type;
    private int size;

    public Shoe (String name, int quantity, String category, String type, int size ) {
        super(name, quantity, category);
        this.type = type;
        this.size = size;
    }

    public String getType () {
        return type;
    }

    public int getSize () {
        return size;
    }

//    @Override
//    public String toString() {
//        return "Item Name: " + getName() + ", Category: " + getCategory() + ", Type: " + getType() + ", Size: " + getSize() + ", Qty: " + getQuantity();
//    }

    @Override
    public String getAll() {
        return "Item Name: " + getName() + ", Category: " + getCategory() + ", Type: " + getType() + ", Size: " + getSize() + ", Qty: " + getQuantity();
    }
}
