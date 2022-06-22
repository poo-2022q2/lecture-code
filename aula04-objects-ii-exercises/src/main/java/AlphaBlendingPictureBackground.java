/**
 * Perform alpha blending between two pictures.
 */
public final class AlphaBlendingPictureBackground {

    private AlphaBlendingPictureBackground() {

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException(
                "Usage: AlphaBlendingPictureBackground foreg_img back_img alpha");
        }

        var picture1 = new Picture(args[0]);
        var picture2 = new Picture(args[1]);
        var alpha = ImageUtils.parseAlphaValue(args[2]);

        AlphaBlendingUtils.blend(picture1, picture2, alpha).show();
    }
}
