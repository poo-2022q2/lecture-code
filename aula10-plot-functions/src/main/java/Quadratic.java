/**
 * Models the quadratic function in the form
 * ax^2 + bx + c
 */
public class Quadratic implements Function {
    private double a;
    private double b;
    private double c;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double evaluate(double x) {
        return a * x * x + b * x + c;
    }
}
