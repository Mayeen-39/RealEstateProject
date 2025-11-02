package realestate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RealEstateProperty class.
 */
public class RealEstatePropertyTest {

    private RealEstateProperty property;

    @BeforeEach
    public void setUp() {
        property = new RealEstateProperty("Budapest", 120000.0, 85.5);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Budapest", property.getLocation());
        assertEquals(120000.0, property.getPrice());
        assertEquals(85.5, property.getArea());
    }

    @Test
    public void testApplyDiscountValid() {
        property.applyDiscount(10);
        assertEquals(108000.0, property.getPrice(), 0.001);
    }

    @Test
    public void testApplyDiscountTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> property.applyDiscount(120));
    }

    @Test
    public void testApplyDiscountNegative() {
        assertThrows(IllegalArgumentException.class, () -> property.applyDiscount(-5));
    }

    @Test
    public void testToStringContainsPropertyInfo() {
        String result = property.toString();
        assertTrue(result.contains("Budapest"));
        assertTrue(result.contains("Price"));
        assertTrue(result.contains("Area"));
    }

    @Test
    public void testZeroDiscount() {
        property.applyDiscount(0);
        assertEquals(120000.0, property.getPrice());
    }
}
