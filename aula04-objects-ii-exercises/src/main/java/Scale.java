/**
 * Scale the image to the target height then display both versions.
 * Uses the nearest-neighbor interpolation algorithm.
 * Based on: https://introcs.cs.princeton.edu/java/31datatype/Scale.java
 */
public final class Scale {

    private Scale() {

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Usage: Scale img width height");
        }

        String filename = args[0];
        int width  = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);

        Picture source = new Picture(filename);
        Picture target = new Picture(width, height);
        double scaleX = (double) width / source.width();
        double scaleY = (double) height / source.height();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int xnew = (int) (x / scaleX);
                int ynew = (int) (y / scaleY);

                target.set(x, y, source.get(xnew, ynew));
            }
        }

        source.show();
        target.show();
    }
}
