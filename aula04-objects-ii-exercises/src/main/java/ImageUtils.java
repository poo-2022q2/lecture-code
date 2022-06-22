/**
 * Utility functions for image processing.
 */
public final class ImageUtils {

    private ImageUtils() {

    }

    /**
     * Parse an RGB value given as a string.
     *
     * @param value the string value
     * @return the integer value in the valid range
     */
    public static int parseRgbValue(String value) {
        int intValue = Integer.parseInt(value);

        if (intValue < 0 || intValue > 255) {
            throw new IllegalArgumentException("RGB value must be in [0,255]");
        }

        return intValue;
    }

    /**
     * Parse an alpha value given as a string.
     *
     * @param value the string value
     * @return the double value in the valid range
     */
    public static double parseAlphaValue(String value) {
        var alphaValue = Double.parseDouble(value);

        if (alphaValue < 0.0 || alphaValue > 1.0) {
            throw new IllegalArgumentException("Alpha value must be in [0.0,1.0]");
        }

        return alphaValue;
    }
}
