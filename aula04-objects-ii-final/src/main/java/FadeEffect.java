import java.awt.*;

/**
 * Builds an animated fade combination filter.
 *
 * Based on: https://introcs.cs.princeton.edu/java/31datatype/Fade.java
 */
public class FadeEffect {

    public static Color combine(Color c1, Color c2, double alpha) {
        int r = (int) (alpha * c1.getRed()   + (1 - alpha) * c2.getRed());
        int g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
        int b = (int) (alpha * c1.getBlue()  + (1 - alpha) * c2.getBlue());
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Usage: FadeEffect nframes img1 img2");
        }

        int n = Integer.parseInt(args[0]);         // # of frames

        Picture picture1 = new Picture(args[1]);   // begin picture
        Picture picture2 = new Picture(args[2]);   // end picture

        int width  = picture1.width();
        int height = picture1.height();

        Picture picture = new Picture(width, height);

        // varies the alpha channel
        for (int k = 0; k <= n; k++) {
            double alpha = 1.0 * k / n;

            // for each alpha channel value, generates a fade combination
            // and shows it
            for (int col = 0; col < width; col++) {
                for (int row = 0; row < height; row++) {
                    Color c1 = picture1.get(col, row);
                    Color c2 = picture2.get(col, row);

                    picture.set(col, row, combine(c2, c1, alpha));
                }
            }
            picture.show();
        }
    }
}
