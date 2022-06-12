public class PrimitiveDataTypes {
    public static void main(String[] args) {
        byte by = 0;        // 8-bit signed integer [-128,127]
        char c = 0;         // 16-bit unsigned integer [0,2^16-1]
        short s = 0;        // 16-bit signed integer [0,2^15-1]
        int i = 0;          // 32-bit signed integer [-2^31,2^31-1]
        long l = 0L;        // 64-bit signed integer [-2^63, 2^63-1]
        float f = 0f;       // 32-bit floating point
        double d = 0;       // 64-bit floating point
        boolean bl = true;  // true, false

        // lossy conversion protection
//        int i1 = 256;
//        short s1 = i1;
    }
}
