public class Item {
    private String name;
    private double price;

//    constructor

    /**
     * @param name the name of the item
     * @param price the price of the item
     */
    public Item(String name, double price){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        if (price < 0) {throw new IllegalArgumentException("Price cannot be less than 0");}
        this.name = name;
        this.price = price;
    }

//    copy constructor

    /**
     * @param item an object of the item class
     */
    public Item(Item item) {
        this.name = item.name;
        this.price = item.price;
    }

//    getters and setters

    /**
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param name the name of the item
     */
    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        this.name = name;
    }

    /**
     * @param price the name of the item
     */
    public void setPrice(double price) {
        if (price < 0){throw new IllegalArgumentException("Price cannot be less than 0");}
        this.price = price;
    }

    /**
     * @param object an object
     * @return true if the item and price of two objects are equal
     */
    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Item item)) return false;
        return this.name.equals(item.name) && this.price == item.price;
    }
    
    /**
     * @return the name of the item and its price
     */
    public String toString() {
        return this.name + ": $" + this.price + " ";
    }
}
