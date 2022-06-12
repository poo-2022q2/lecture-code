public class ArgumentPassing {

    // deep copy
    public static void f(int a) {
        a = a + 1;
    }

    // shallow copy
    public static void g(int[] v) {
        v[0] = 10;
    }

    public static void printArray(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 1;
        int v[] = {1, 2, 3, 4};

        System.out.println(a);
        f(a);
        System.out.println(a);

        printArray(v);
        g(v);
        printArray(v);
    }
}
