package numbers;

import java.util.Arrays;
import java.util.Random;

public class MaximumNumber {

    public static Number maximum(Number[] numbers) {
        if (numbers.length < 1)
            return 0;

        Number maxNumber = numbers[0];

        for (Number n: numbers) {
            if (n.doubleValue() > maxNumber.doubleValue())
                maxNumber = n;
        }

        return maxNumber;
    }

    public static Number abs(Number number) {
        if (number.doubleValue() < 0)
            return -number.doubleValue();
        return number;
    }

    public static void main(String[] args) {
        Number[] numbers = new Number[] {
          10.0,
          15f,
          25,
          (short )'a'
        };

        System.out.println(maximum(numbers));

        Random random = new Random();

        Number[] randomBigNumbers = new Number[] {
            random.nextDouble() * Double.MAX_VALUE,
            random.nextFloat() * Float.MAX_VALUE,
            random.nextGaussian() * Double.MAX_VALUE,
            random.nextInt(Integer.MAX_VALUE),
            random.nextLong()
        };

        System.out.println(Arrays.toString(randomBigNumbers));
        System.out.println(maximum(randomBigNumbers));

        System.out.println();

        System.out.println(abs(-10));
        System.out.println(abs(-125.43));
        System.out.println(abs(-34f));

    }
}
