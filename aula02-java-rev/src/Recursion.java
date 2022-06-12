public class Recursion {

    // simple recursion
    public static long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException(
                    "n must be positive");

        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    // double recursion
    public static long nthFibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        return nthFibonacci(n-1) + nthFibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(10));

        System.out.println();

        System.out.println(nthFibonacci(0));
        System.out.println(nthFibonacci(1));
        System.out.println(nthFibonacci(2));
        System.out.println(nthFibonacci(3));
        System.out.println(nthFibonacci(4));
        System.out.println(nthFibonacci(10));
    }
}
