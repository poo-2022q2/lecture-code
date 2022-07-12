import java.util.Arrays;

public final class PlotTest {

    private PlotTest() {

    }

    public static void main(String[] args) {
        // y = x
        double[] y = new double[30];

        for (int i = 0; i < 30; i++) {
            y[i] = (double )i / 10;
        }

        System.out.println(Arrays.toString(y));

        StdStats.plotPoints(y);
        StdStats.plotLines(y);
    }
}
