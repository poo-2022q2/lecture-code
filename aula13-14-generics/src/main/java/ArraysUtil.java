public final class ArraysUtil {
    private ArraysUtil() {

    }

    public static <T> String toString(T[] elements) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static <T extends Comparable<T>> boolean equals(T[] a, T[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Selection sort (inline).
     * Warn: performing some redundant checks to simplify the algorithm.
     * @param v the input array
     * @param <T> the generic array type
     */
    public static <T extends Comparable<T>> void sort(T[] v) {
        for (int i = 0; i < v.length; i++) {
            int k = i;

            for (int j = i; j < v.length; j++) {
                if (v[j].compareTo(v[k]) < 0) {
                    k = j;
                }
            }
            // swap elements i and k
            T temp = v[i];
            v[i] = v[k];
            v[k] = temp;
        }
    }

    public static void main(String[] args) {
//        Integer[] v1 = {1, 2, 3, 4};
//        Double[] v2 = {1.1, 2.2, 3.3, 4.4};
//        String[] v3 = {"hello", "wonderful", "world"};
//
//        System.out.println(ArraysUtil.toString(v1));
//        System.out.println(ArraysUtil.toString(v2));
//        System.out.println(ArraysUtil.toString(v3));

        Integer[] v = {5, 4, 3, 2, 1};

        System.out.println(ArraysUtil.toString(v));
        ArraysUtil.sort(v);
        System.out.println(ArraysUtil.toString(v));

        Double[] v1 = {5.2, 4.3, 3.11, 2.32, 1.09};

        System.out.println(ArraysUtil.toString(v1));
        ArraysUtil.sort(v1);
        System.out.println(ArraysUtil.toString(v1));

    }
}
