package realestate;

import java.util.logging.*;

/**
 * Represents a real estate property with location, price, and area.
 */
public class RealEstateProperty {

    private static final Logger logger = Logger.getLogger(RealEstateProperty.class.getName());

    private String location;
    private double price;
    private double area;

    /**
     * Constructs a new RealEstateProperty instance.
     *
     * @param location the property's location
     * @param price the property's price in USD
     * @param area the property's size in square meters
     */
    public RealEstateProperty(String location, double price, double area) {
        logger.info("Constructor called with location=" + location + ", price=" + price + ", area=" + area);
        this.location = location;
        this.price = price;
        this.area = area;
    }

    /**
     * Applies a percentage discount to the property’s price.
     *
     * @param percent the discount percentage (0–100)
     * @throws IllegalArgumentException if the percentage is invalid
     */
    public void applyDiscount(double percent) {
        logger.info("applyDiscount() called with percent=" + percent);
        try {
            if (percent < 0 || percent > 100) {
                throw new IllegalArgumentException("Invalid discount percentage: " + percent);
            }
            double discount = price * (percent / 100);
            price -= discount;
            logger.info("Discount applied. New price: " + price);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Failed to apply discount", e);
            throw e;
        }
    }

    /**
     * Gets the property price.
     *
     * @return the current property price
     */
    public double getPrice() {
        logger.info("getPrice() called");
        return price;
    }

    /**
     * Gets the property location.
     *
     * @return the location of the property
     */
    public String getLocation() {
        logger.info("getLocation() called");
        return location;
    }

    /**
     * Gets the property area.
     *
     * @return the area of the property in square meters
     */
    public double getArea() {
        logger.info("getArea() called");
        return area;
    }

    /**
     * Provides a formatted string representation of the property.
     *
     * @return property details as a string
     */
    @Override
    public String toString() {
        logger.info("toString() called");
        return "Property in " + location + " [Price: $" + price + ", Area: " + area + " sqm]";
    }
}
