import java.awt.Color;

/**
 * Apply alpha compositing to an image given a background color and a value.
 */
public final class AlphaBlendingUtils {

    private AlphaBlendingUtils() {

    }

    /**
     * Blend two colors using alpha compositing.
     *
     * @param colorA the foreground color
     * @param colorB the background color
     * @param alpha  the alpha value
     * @return the blended color
     */
    public static Color blend(Color colorA, Color colorB, double alpha) {
        return new Color(
            (int) (alpha * colorA.getRed() + (1.0 - alpha) * colorB.getRed()),
            (int) (alpha * colorA.getGreen() + (1.0 - alpha) * colorB.getGreen()),
            (int) (alpha * colorA.getBlue() + (1.0 - alpha) * colorB.getBlue())
        );
    }

    /**
     * Blend all pixels of an image using alpha compositing.
     *
     * @param picture    the input picture
     * @param background the background color
     * @param alpha      the alpha value
     * @return the resulting picture
     */
    public static Picture blend(Picture picture, Color background, double alpha) {
        var result = new Picture(picture.width(), picture.height());

        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                result.set(i, j, blend(picture.get(i, j), background, alpha));
            }
        }

        return result;
    }

    /**
     * Blend all pixels of two images using alpha compositing.
     *
     * @param picture    the foreground picture
     * @param background the background picture
     * @param alpha      the alpha value
     * @return the blended picture
     */
    public static Picture blend(Picture picture, Picture background, double alpha) {
        if (picture.width() != background.width() || picture.height() != background.height()) {
            throw new IllegalArgumentException("Foreground and background pictures "
                + "must have same dimensions");
        }

        var result = new Picture(picture.width(), picture.height());

        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                result.set(i, j, blend(picture.get(i, j), background.get(i, j), alpha));
            }
        }

        return result;
    }

    /**
     * Blend all pixels of two images using alpha compositing. This version mutates the result
     * parameter.
     *
     * @param picture    the foreground picture
     * @param background the background picture
     * @param alpha      the alpha value
     */
    public static void blend(Picture picture, Picture background, Picture result, double alpha) {
        if (picture.width() != background.width() || picture.height() != background.height()) {
            throw new IllegalArgumentException(
                "Foreground and background pictures must have same dimensions");
        }
        if (picture.width() != result.width() || picture.height() != result.height()) {
            throw new IllegalArgumentException(
                "Input and result pictures must have same dimensions");
        }

        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                result.set(i, j, blend(picture.get(i, j), background.get(i, j), alpha));
            }
        }
    }
}
