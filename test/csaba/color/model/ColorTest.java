package csaba.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorTest {
    private Color colorRGBInt;
    private Color colorRGBHex;

    @BeforeEach
    public void setUp() {
        colorRGBInt = new Color(10, 50, 150);
        colorRGBHex = new Color("#0A3296");
    }

    @AfterEach
    public void tearDown() {
        colorRGBInt = null;
        colorRGBHex =  null;
    }

    @Test
    public void test_get_red() {
        assertEquals(10, colorRGBInt.getRed());
        assertEquals(50, colorRGBInt.getGreen());
        assertEquals(150, colorRGBInt.getBlue());
        assertEquals("#0A3296", colorRGBInt.getHexValue());
        assertEquals(10, colorRGBHex.getRed());
        assertEquals(50, colorRGBHex.getGreen());
        assertEquals(150, colorRGBHex.getBlue());
        assertEquals("#0A3296", colorRGBHex.getHexValue());
    }

    @Test
    public void test_set_red() {
        colorRGBInt.setRed(20);
        colorRGBHex.setRed(20);
        assertEquals(20, colorRGBInt.getRed());
        assertEquals(50, colorRGBInt.getGreen());
        assertEquals(150, colorRGBInt.getBlue());
        assertEquals("#143296", colorRGBInt.getHexValue());
        assertEquals(20, colorRGBHex.getRed());
        assertEquals(50, colorRGBHex.getGreen());
        assertEquals(150, colorRGBHex.getBlue());
        assertEquals("#143296", colorRGBHex.getHexValue());
    }

    @Test
    public void test_set_green() {
        colorRGBInt.setGreen(60);
        colorRGBHex.setGreen(60);
        assertEquals(10, colorRGBInt.getRed());
        assertEquals(60, colorRGBInt.getGreen());
        assertEquals(150, colorRGBInt.getBlue());
        assertEquals("#0A3C96", colorRGBInt.getHexValue());
        assertEquals(10, colorRGBHex.getRed());
        assertEquals(60, colorRGBHex.getGreen());
        assertEquals(150, colorRGBHex.getBlue());
        assertEquals("#0A3C96", colorRGBHex.getHexValue());
    }

    @Test
    public void test_set_blue() {
        colorRGBInt.setBlue(160);
        colorRGBHex.setBlue(160);
        assertEquals(10, colorRGBInt.getRed());
        assertEquals(50, colorRGBInt.getGreen());
        assertEquals(160, colorRGBInt.getBlue());
        assertEquals("#0A32A0", colorRGBInt.getHexValue());
        assertEquals(10, colorRGBHex.getRed());
        assertEquals(50, colorRGBHex.getGreen());
        assertEquals(160, colorRGBHex.getBlue());
        assertEquals("#0A32A0", colorRGBHex.getHexValue());
    }

    @Test
    public void test_set_hex_value() {
        colorRGBInt.setHexValue("#0A32A0");
        colorRGBHex.setHexValue("#0A32A0");
        assertEquals(10, colorRGBInt.getRed());
        assertEquals(50, colorRGBInt.getGreen());
        assertEquals(160, colorRGBInt.getBlue());
        assertEquals("#0A32A0", colorRGBInt.getHexValue());
        assertEquals(10, colorRGBHex.getRed());
        assertEquals(50, colorRGBHex.getGreen());
        assertEquals(160, colorRGBHex.getBlue());
        assertEquals("#0A32A0", colorRGBHex.getHexValue());
    }

    @Test
    public void test_to_string() {
        assertEquals("[value=#0A3296, r=10, g=50, b=150]", colorRGBInt.toString());
        assertEquals("[value=#0A3296, r=10, g=50, b=150]", colorRGBHex.toString());
    }

    @Test
    public void test_set_red_with_invalid_value() {
        assertThrows(IllegalArgumentException.class, () -> colorRGBInt.setRed(-20));
        assertThrows(IllegalArgumentException.class, () -> colorRGBHex.setRed(-20));
    }

    @Test
    public void test_set_green_with_invalid_value() {
        assertThrows(IllegalArgumentException.class, () -> colorRGBInt.setGreen(-20));
        assertThrows(IllegalArgumentException.class, () -> colorRGBHex.setGreen(-20));
    }

    @Test
    public void test_set_blue_with_invalid_value() {
        assertThrows(IllegalArgumentException.class, () -> colorRGBInt.setBlue(-20));
        assertThrows(IllegalArgumentException.class, () -> colorRGBHex.setBlue(-20));
    }

    @Test
    public void test_set_hex_value_with_invalid_value() {
        assertThrows(IllegalArgumentException.class, () -> colorRGBInt.setHexValue("$MS00AA"));
        assertThrows(IllegalArgumentException.class, () -> colorRGBHex.setHexValue("$MS00AA"));
    }

    @Test
    public void test_constructors() {
        assertThrows(IllegalArgumentException.class, () -> new Color(300, 50, 150));
        assertThrows(IllegalArgumentException.class, () -> new Color("$BB00AA"));
    }

    @Test
    public void test_null_values() {
        assertThrows(IllegalArgumentException.class, () -> colorRGBInt.setHexValue(null));
        assertThrows(IllegalArgumentException.class, () -> colorRGBHex.setHexValue(null));
    }
}
