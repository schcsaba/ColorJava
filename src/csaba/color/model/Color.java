package csaba.color.model;

public class Color {

    private int red;
    private int green;
    private int blue;
    private String hexValue;
    public Color(int red, int green, int blue) {
        checkColorIntValue(red);
        checkColorIntValue(green);
        checkColorIntValue(blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        hexValue = rgbToHex(red, green, blue);
    }

    public Color(String hexValue) {
        checkHexValue(hexValue);
        this.hexValue =  hexValue;
        red = Integer.valueOf(hexValue.substring(1, 3), 16);
        green = Integer.valueOf(hexValue.substring(3, 5), 16);
        blue = Integer.valueOf(hexValue.substring(5, 7), 16);
    }

    @Override
    public String toString() {
        return "[value=" + hexValue + ", r=" + red + ", g=" + green + ", b=" + blue + "]";
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        checkHexValue(hexValue);
        this.hexValue = hexValue;
        red = Integer.valueOf(hexValue.substring(1, 3), 16);
        green = Integer.valueOf(hexValue.substring(3, 5), 16);
        blue = Integer.valueOf(hexValue.substring(5, 7), 16);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        checkColorIntValue(red);
        this.red = red;
        hexValue = rgbToHex(red, green, blue);
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        checkColorIntValue(green);
        this.green = green;
        hexValue = rgbToHex(red, green, blue);
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        checkColorIntValue(blue);
        this.blue = blue;
        hexValue = rgbToHex(red, green, blue);
    }

    private void checkColorIntValue(int color) {
        if (color < 0 || color > 255) {
            throw new IllegalArgumentException("The color value should be between 0 and 255.");
        }
    }

    private void checkHexValue(String hexValue) {
        if (hexValue == null) {
            throw new IllegalArgumentException("The hex value is null.");
        }
        if (hexValue.length() != 7) {
            throw new IllegalArgumentException("The length of the hex value should be 7.");
        }
        if (hexValue.charAt(0) != '#') {
            throw new IllegalArgumentException("The hex value should start with a # character.");
        }
        for (int i = 1; i < hexValue.length(); i++) {
            if (Character.isAlphabetic(hexValue.charAt(i)) && !Character.isUpperCase(hexValue.charAt(i))) {
                throw new IllegalArgumentException("The characters of the hex value should be uppercase.");
            }
        }
    }

    private String rgbToHex(int red, int green, int blue) {
        return String.format("#%02X%02X%02X", red, green, blue);
    }
}
