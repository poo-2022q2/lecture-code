/**
 * Implements function ax + b
 */
public class Linear implements Function {
    private double a;
    private double b;

    public Linear(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double evaluate(double x) {
        return a * x + b;
    }
}
