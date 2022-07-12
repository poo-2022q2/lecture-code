import java.awt.*;

public final class FunctionTest {

    private FunctionTest() {

    }

    /**
     * Plot a function with n points in the interval [a,b].
     * @param f the function
     * @param a the interval lower limit
     * @param b the interval upper limit
     * @param n number of points
     */
    public static void plot(Function f, double a, double b, int n) {
        double[] y = new double[n+1];
        double delta = (b - a) / n;

        for (int i = 0; i <= n; i++) {
            y[i] = f.evaluate(a + delta * i);
        }

        StdStats.plotPoints(y);
        StdStats.plotLines(y);
    }

    public static void main(String[] args) {
        Square square = new Square();          // y = x * x
        Linear linear = new Linear(1, 0); // y = x
        Linear linear2 = new Linear(0.2, 0.3); // y = 2x + 3

        Function cubic = (double x) -> x * x * x;

        Quadratic quadratic = new Quadratic(1, -0.3, 0.4);

        plot(square, -0.6, 0.6, 50);
        StdDraw.setPenColor(Color.red);
        plot(linear, -0.6, 0.6, 50);
        StdDraw.setPenColor(Color.green);
        plot(linear2, -0.6, 0.6, 50);
        StdDraw.setPenColor(Color.blue);
        plot(quadratic, -0.6, 0.6, 50);
        StdDraw.setPenColor(Color.orange);
        plot(cubic, -0.6, 0.6, 50);
    }
}
