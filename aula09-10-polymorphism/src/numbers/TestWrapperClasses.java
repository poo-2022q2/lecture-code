package numbers;

import java.math.BigInteger;

public class TestWrapperClasses {
    public static void main(String[] args) {
        Integer i1 = 10;
        Double d = 10.0;
        Float f = 20f;
        Boolean b = true;
        BigInteger bi = BigInteger.valueOf(1000);

        System.out.println(i1 instanceof  Object);
    }
}
