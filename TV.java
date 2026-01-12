

public class TV extends Product {
    private String screenType;
    private String resolution;
    private double displaySize; // inches

    public TV(String itemNumber, String productName, int quantity, double price,
              String screenType, String resolution, double displaySize) {//status is true by default
        super(itemNumber, productName, quantity, price);
        this.screenType = screenType;
        this.resolution = resolution;
        this.displaySize = displaySize;
    }
    
    //Getter/Setter
    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    @Override
    public String toString() {
        return    "Item number       : " + getItemNumber() + "\n"
                + "Product name      : " + getProductName() + "\n"
                + "Screen type       : " + screenType + "\n"
                + "Resolution        : " + resolution + "\n"
                + "Display size:" + displaySize + "\n"
                + "Quantity available: " + getQuantity() + "\n"
                + "Price (RM)        : " + getPrice() + "\n"
                + "Inventory value (RM): " + getInventoryValue() + "\n"
                + "Product status    : " + (isActive() ? "Active" : "Discontinued") + "\n";
    }
}
