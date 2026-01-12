public abstract class Product {
    // Instance variables
    private String itemNumber;
    private String productName;
    private int quantity;
    private double price;
    private boolean status; // true = active, false = discontinued

    // Default constructor
    public Product() {
        this.status = true; 
    }

    // Parameterized constructor
    public Product(String itemNumber, String productName, int quantity, double price) {
        this.itemNumber = itemNumber;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.status = true;
    }

    // Getter and Setter methods
    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Method to get inventory value
    public double getInventoryValue() {
        return quantity * price;
    }

    // Method to add stock (only if product is active)
    public void addStock(int quantityToAdd) {
        if (status) {
            this.quantity += quantityToAdd;
        } else {
            System.out.println("Cannot add stock. Product is discontinued.");
        }
    }

    // Method to deduct stock
    public void deductStock(int quantityToDeduct) {
        if (quantityToDeduct <= this.quantity) {
            this.quantity -= quantityToDeduct;
        } else {
            System.out.println("Cannot deduct more than available stock.");
        }
    }

    // Override toString method
    @Override
    public String toString() {
        return "Item number       : " + itemNumber + "\n"
             + "Product name      : " + productName + "\n"
             + "Quantity available: " + quantity + "\n"
             + "Price (RM)        : " + price + "\n"
             + "Inventory value (RM): " + getInventoryValue() + "\n"
             + "Product status    : " + (status ? "Active" : "Discontinued") + "\n";
    }
}