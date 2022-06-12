public class Arrays {
  public static void main(String[] args) {
    double[] a;

    // memory allocation
    a = new double[10];

    for (int i = 0; i < a.length; i++)
      a[i] = i + i / 10.0;

    for (int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
    System.out.println();

    // initialization
    double[] b = {1.1, 1.2, 1.3, 1.4};

    for (double v : b) System.out.print(v + " ");
    System.out.println();

    System.out.println();

    // shallow copy (aliasing)
    double[] c = a;

    c[1] = 10.5;

    for (double v: a) System.out.print(v + " ");
    System.out.println();
    for (double v: c) System.out.print(v + " ");

  }
}
