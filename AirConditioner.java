

//extra class to show Application extension ¨C Extend the application by adding new types of product class.
public class AirConditioner extends Product {
    private String acType;
    private String energyRating;
    private double coolingCapacity;
    
    public AirConditioner(String itemNumber, String productName, int quantity, double price, String acType, String energyRating, double coolingCapacity)
    {
        super (itemNumber, productName, quantity, price);
        this.acType = acType;
        this.coolingCapacity = coolingCapacity;
        this.energyRating = energyRating;
    }

    public String getAcType() {
        return acType;
    }

    public void setACType(String acType) {
        this.acType = acType;
    }  

    public String getEnergyRating() {
        return energyRating;
    }

    public void setEnergyRating(String energyRating) {
        this.energyRating = energyRating;
    }
    
    public double getCoolingCapacity() {
        return coolingCapacity;
    }

    public void setCoolingCapacity(double coolingCapacity) {
        this.coolingCapacity = coolingCapacity;
    }

    @Override
    public String toString() {
        return    "Item number       : " + getItemNumber() + "\n"
                + "Product name      : " + getProductName() + "\n"
                + "Air conditioner type       : " + acType + "\n"
                + "Energy Rating     : " + energyRating + "\n"
                + "Cooling Capacity  : " + coolingCapacity + "\n"
                + "Quantity available: " + getQuantity() + "\n"
                + "Price (RM)        : " + getPrice() + "\n"
                + "Inventory value (RM): " + getInventoryValue() + "\n"
                + "Product status    : " + (isActive() ? "Active" : "Discontinued") + "\n";
    }


}