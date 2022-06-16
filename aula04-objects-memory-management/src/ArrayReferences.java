import java.util.Arrays;

public class ArrayReferences {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        // shallow equality
        System.out.println(a == b);
        // deep equality (sort of, only one level)
        System.out.println(Arrays.equals(a, b));

        System.out.println();

        // shallow print
        System.out.println(a);
        System.out.println(b);
        // deep print
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        System.out.println();

        // shallow copy (aliasing)
        int[] c = a;

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(c));
        c[1] = 4;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(c));

        System.out.println();

        // deep copy
        int[] d = Arrays.copyOf(a, a.length);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(d));
        c[1] = 5;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(d));
    }
}
