public class StaticMethods {

  public static long abs(long v) {
    return (v < 0) ? -v : v;
  }

  /**
   * Power function with integer base and exponent
   * @param b the integer base > 0
   * @param e the integer exponent
   * @return the power
   */
  public static double power(long b, long e) {
    long p = 1;

    if (b == 0 && e > 0)
      return 0;
    if (b == 0 && e < 0)
      throw new UnsupportedOperationException(
              "Zero base with negative exponent is undefined");

    long absE = abs(e);
    for (int i = 0; i < absE; i++)
      p *= b;

    if (e < 0)
      return 1.0 / p;

    return p;
  }

  public static void main(String[] args) {
    System.out.println(power(2,3));
    System.out.println(power(2,-3));
    System.out.println(power(10,5));
    System.out.println(power(10,-5));
    System.out.println(power(10,0));
    System.out.println(power(0, 10));
    System.out.println(power(0, 0));
    System.out.println(power(0,-1));
  }
}
