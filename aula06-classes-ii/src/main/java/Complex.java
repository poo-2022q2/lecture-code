import java.util.Objects;

/**
 * An immutable complex number.
 */
public class Complex {

    /**
     * The real part.
     */
    private final double re;

    /**
     * The imaginary part.
     */
    private final double im;

    /**
     * Constructor.
     *
     * @param real the real part
     * @param imag the imaginary part
     */
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public String toString() {
        if (im == 0) {
            return re + "";
        }
        if (re == 0) {
            return im + "i";
        }
        if (im < 0) {
            return re + " - " + (-im) + "i";
        }
        return re + " + " + im + "i";
    }

    /**
     * Abs/modulus/magnitude
     *
     * @return the absolute number
     */
    public double abs() {
        return Math.hypot(re, im);
    }

    /**
     * Angle/phase/argument, normalized to be between -pi and pi
     *
     * @return the value
     */
    public double phase() {
        return Math.atan2(im, re);
    }

    /**
     * Add this complex number to the another complex number.
     *
     * @param other the other complex number
     * @return the result of the addition
     */
    public Complex plus(Complex other) {
        return new Complex(this.re + other.re, this.im + other.im);
    }

    // return a new Complex object whose value is (this - b)

    /**
     * Subtract another complex number from this number.
     *
     * @param other the other complex number
     * @return the result of the subtraction
     */
    public Complex minus(Complex other) {
        return new Complex(this.re - other.re, this.im - other.im);
    }

    /**
     * Compute two product between this complex number and another one.
     *
     * @param other the other complex number
     * @return the result of the multiplication
     */
    public Complex times(Complex other) {
        Complex a = this;
        double real = a.re * other.re - a.im * other.im;
        double imag = a.re * other.im + a.im * other.re;
        return new Complex(real, imag);
    }

    /**
     * The product between the complex number and a scalar.
     *
     * @param scalar the scalar
     * @return the product
     */
    public Complex scale(double scalar) {
        return new Complex(scalar * re, scalar * im);
    }

    /**
     * The conjugate of the complex number.
     *
     * @return the conjugate
     */
    public Complex conjugate() {
        return new Complex(re, -im);
    }

    /**
     * The reciprocal of a complex number.
     *
     * @return the reciprocal
     */
    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    /**
     * The reak part of the complex number.
     *
     * @return the real part
     */
    public double re() {
        return re;
    }

    /**
     * The imaginary part of the complex number.
     *
     * @return the imaginary part
     */
    public double im() {
        return im;
    }

    /**
     * Divides this complex by another complex number.
     *
     * @param other the other complex number
     * @return the division result
     */
    public Complex divides(Complex other) {
        Complex a = this;
        return a.times(other.reciprocal());
    }

    /**
     * The complex exponential.
     *
     * @return the complex exponential
     */
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    /**
     * The complex sine.
     *
     * @return the complex sin.
     */
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    /**
     * The complex cosine.
     *
     * @return the complex cosine
     */
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    /**
     * The complex tangent.
     *
     * @return the complex tangent
     */
    public Complex tan() {
        return sin().divides(cos());
    }


    /**
     * Add two complex numbers.
     *
     * @param a the first complex number
     * @param b the second complex number
     * @return the addition result
     */
    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;

        return new Complex(real, imag);
    }

    /**
     * Compares this complex number to other complex number.
     *
     * @param x the other complex number
     * @return true if the numbers are equal, false otherwise
     */
    public boolean equals(Object x) {
        if (x == null) {
            return false;
        }
        if (this.getClass() != x.getClass()) {
            return false;
        }
        Complex that = (Complex) x;
        return (this.re == that.re) && (this.im == that.im);
    }


    /**
     * Generate a hashcode from the complex number.
     *
     * @return the hashcode
     */
    public int hashCode() {
        return Objects.hash(re, im);
    }

}
