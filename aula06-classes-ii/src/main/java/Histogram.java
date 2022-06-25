import java.util.Arrays;

/**
 * Histogram to count frequencies of integers between 0 and n-1.
 */
public class Histogram {

    /**
     * The frequencies
     */
    private final int[] freqs;

    /**
     * The max frequency.
     */
    private double max;            // max frequency of any value

    /**
     * Constructor.
     *
     * @param n the quantity of positions.
     */
    public Histogram(int n) {
        freqs = new int[n];
    }

    /**
     * Increment the frequency of i-th position.
     *
      * @param i the position
     */
    public void addDataPoint(int i) {
        freqs[i]++;
        if (freqs[i] > max) max = freqs[i];
    }

    /**
     * The the frequency of a position to a specific value.
     *
     * @param i the position
     * @param value the value
     */
    public void setFreq(int i, int value) {
        freqs[i] = value;
        if (value > max) max = value;
    }

    /**
     * Convert the histogram to an array.
     *
     * @return the array
     */
    public int[] toArray() {
        return Arrays.copyOf(freqs, freqs.length);
    }

    public String toString() {
        return Arrays.toString(freqs);
    }

    /**
     * Convert the histogram to an array of doubles.
     *
     * @return the array of doubles
     */
    private double[] toDoubleFreqs() {
        double[] doubleFreqs = new double[freqs.length];

        for (int i = 0; i < freqs.length; i++) {
            doubleFreqs[i] = freqs[i];
        }
        return doubleFreqs;
    }


    /**
     * Draw the histogram in a GUI.
     */
    public void draw() {
        StdDraw.setYscale(-1, max + 1);  // to leave a little border

        StdStats.plotBars(toDoubleFreqs());
    }

    /**
     * Ad-hoc tests
     *
     * @param args the args
     */
    public static void main(String[] args) {
        Histogram histogram = new Histogram(10);

        for (int i = 0; i < histogram.freqs.length; i++) {
            histogram.setFreq(i, i * 10);
        }

        histogram.draw();
    }


} 
