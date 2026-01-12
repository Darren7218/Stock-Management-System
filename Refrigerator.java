public class Refrigerator extends Product {
    // Additional attributes
    private String doorDesign;
    private String color;
    private int capacity;

    public Refrigerator(String itemNumber, String productName, int quantity, double price,
                        String doorDesign, String color, int capacity) {//status is true by default
        super(itemNumber, productName, quantity, price);
        this.doorDesign = doorDesign;
        this.color = color;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getDoorDesign() {
        return doorDesign;
    }

    public void setDoorDesign(String doorDesign) {
        this.doorDesign = doorDesign;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Override toString to match assignment format
    @Override
    public String toString() {
        return "Item number       : " + getItemNumber() + "\n"
             + "Product name      : " + getProductName() + "\n"
             + "Door design       : " + doorDesign + "\n"
             + "Color             : " + color + "\n"
             + "Capacity (in Litres): " + capacity + "\n"
             + "Quantity available: " + getQuantity() + "\n"
             + "Price (RM)        : " + getPrice() + "\n"
             + "Inventory value (RM): " + getInventoryValue() + "\n"
             + "Product status    : " + (isActive() ? "Active" : "Discontinued") + "\n";
    }
}