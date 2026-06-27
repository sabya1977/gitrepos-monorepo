public class Main
    {
    public static void main(String[] args) {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
        Fruit fruits = new Fruit("Fruits", 20, "Apple", "Simla Apple");
        Shoe shoes = new Shoe ("Footwear", 20, "Shoes",  "Formal", 8);
        Item generic = new Item("Generic", 0, "N/A");

        Inventory inventory = new Inventory();

        inventory.addItem(fruits);
        inventory.addItem(shoes);
        inventory.addItem(generic);

        inventory.displayInventory();
        }
}
