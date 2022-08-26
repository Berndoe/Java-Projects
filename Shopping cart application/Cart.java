import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> cart;


    public Cart() {
        this.cart = new ArrayList<>();
    }

    /**
     * @param index the position of the item in the arraylist
     * @return the item at the specified index
     */
    public Item getItem(int index) {
        return new Item(this.cart.get(index));
    }

    /**
     * @param index the position of the item in the arraylist
     * @param item  an object of the Item class
     */
    public void setItem(int index, Item item) {
        this.cart.set(index, new Item(item));
    }

    /**
     * @param item an object of the Item class
     * @return true if item has been added
     */
    public boolean addItem(Item item) {
        if (!this.cart.contains(item)) {
            this.cart.add(new Item(item));
            return true;
        }
        return false;
    }

    /**
     * @param name the name of the item
     */
    public void removeItem(String name) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("You cannot delete from an empty list");
        }
        for (int i = 0; i < cart.size(); i++) {
            if (this.cart.get(i).getName().equalsIgnoreCase(name)) {
                this.cart.remove(i);
            }
        }
    }

    /**
     * @return a receipt with the total
     */
    public String checkOut() {
        DecimalFormat number = new DecimalFormat("#.##"); // rounds total to 2 d.p.
        if (cart.isEmpty()) {
            throw new IllegalStateException("You cannot checkout with an empty cart");
        }
        double subTotal = 0;
        for (Item item : this.cart) {
            subTotal += item.getPrice();

        }
        double tax = 0.13 * subTotal;
        double total = Double.parseDouble(number.format(subTotal + tax));

        return "\tRECEIPT \n\n" +
                "\tSubtotal: $" + subTotal + "\n" +
                "\tTax: $" + tax + "\n" +
                "\tTotal: $" + total + "\n";
    }

    /**
     * @return true if the cart is empty
     */
    public boolean isEmpty() {
        return this.cart.isEmpty();
    }

    /**
     * @return the name of the item and the price
     */
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Item item : this.cart) {
            temp.append(item.toString());
            temp.append("\n");
        }
        return temp.toString();
    }

}
