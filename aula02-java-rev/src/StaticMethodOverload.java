public class StaticMethodOverload {

    public static int abs(int v) {
        System.err.println("int version");
        return (v >= 0) ? v : -v;
    }

    public static long abs(long v) {
        System.err.println("long version");
        return (v >= 0) ? v : -v;
    }

    public static short abs(short v) {
        System.err.println("short version");
        return (v >= 0) ? v : (short) -v;
    }

    public static double abs(double v) {
        System.err.println("double version");
        return (v >= 0) ? v : -v;
    }

    public static float abs(float v) {
        System.err.println("float version");
        return (v >= 0) ? v : -v;
    }

    public static void main(String[] args) {
        System.out.println(abs(-1));
        System.out.println(abs(-1L));
        System.out.println(abs((short)1));
        System.out.println(abs(-1.0));
        System.out.println(abs(-1.0f));
    }
}
