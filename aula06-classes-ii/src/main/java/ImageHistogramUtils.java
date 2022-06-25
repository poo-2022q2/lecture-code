import java.awt.Color;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class to computer image histograms.
 */
public class ImageHistogramUtils {

    /**
     * Generate a histogram from a grayscale picture.
     *
     * @param picture the picture
     * @return the histogram
     */
    public static Histogram fromGrayscalePicture(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Histogram histogram = new Histogram(256);

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);

                histogram.addDataPoint(color.getRed());
            }
        }

        return histogram;
    }

    /**
     * Export the histogram to a text file
     *
     * @param histogram the histogram object
     * @param path the file path
     */
    public static void toFile(Histogram histogram, String path) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            for (Integer freq : histogram.toArray()) {
                writer.write(freq.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to create histogram file");
            e.printStackTrace();
        }
    }

    /**
     * Ad-hoc tests.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Histogram histogram = ImageHistogramUtils.fromGrayscalePicture(new Picture("data/3096.jpg"));

        System.out.println(histogram);
        histogram.draw();
    }
}
