import java.awt.Color;

/**
 * Perform alpha blending of an image and a solid background.
 */
public final class AlphaBlendSolidBackgound {

    private AlphaBlendSolidBackgound() {

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        if (args.length < 5) {
            throw new IllegalArgumentException("Usage: AlphaBlending imagePath r g b alpha");
        }

        var picture = new Picture(args[0]);
        var background = new Color(ImageUtils.parseRgbValue(args[1]),
            ImageUtils.parseRgbValue(args[2]), ImageUtils.parseRgbValue(args[3]));
        var alphaValue = ImageUtils.parseAlphaValue(args[4]);

        var result = AlphaBlendingUtils.blend(picture, background, alphaValue);

        picture.show();
        result.show();
    }
}
