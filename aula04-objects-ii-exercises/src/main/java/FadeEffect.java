/**
 * Builds an animated fade combination filter based on alpha blending.
 * Uses a background image instead of a solid color.
 * Based on: https://introcs.cs.princeton.edu/java/31datatype/Fade.java
 */
public final class FadeEffect {

    private FadeEffect() {

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Usage: FadeEffect <frames> <img1> <img2>");
        }

        int frames = Integer.parseInt(args[0]);         // # of frames

        Picture picture1 = new Picture(args[1]);   // begin picture
        Picture picture2 = new Picture(args[2]);   // end picture

        Picture result = new Picture(picture1.width(), picture1.height()); // result picture

        // varies the alpha channel
        for (int step = 0; step <= frames; step++) {
            double alpha = (double) step / frames;

            System.out.println(alpha);

            // for each alpha channel value, generates a fade combination
            // and shows it            
            AlphaBlendingUtils.blend(picture2, picture1, result, alpha);

            result.show();
        }
    }
}
