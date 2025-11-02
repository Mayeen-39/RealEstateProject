package realestate;

import java.io.IOException;
import java.util.logging.*;

/**
 * Main class for the RealEstate application.
 * Demonstrates logging setup and method tracing.
 */
public class RealEstateApp {

    private static final Logger logger = Logger.getLogger(RealEstateApp.class.getName());

    static {
        try {
            LogManager.getLogManager().reset();

            FileHandler fileHandler = new FileHandler("realEstateApp.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.addHandler(new ConsoleHandler());
            logger.setLevel(Level.INFO);

        } catch (IOException e) {
            System.err.println("Failed to setup logger: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logger.info("Application started.");

        try {
            RealEstateApp app = new RealEstateApp();
            app.start();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error occurred in main method", e);
        }
    }

    /**
     * Starts the RealEstate application.
     */
    public void start() {
        logger.info("start() called");

        RealEstateProperty property = new RealEstateProperty("Budapest", 120000.0, 85.5);
        logger.info("Created property: " + property);

        try {
            property.applyDiscount(10);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error applying discount", e);
        }

        logger.info("Application finished successfully.");
    }
}
