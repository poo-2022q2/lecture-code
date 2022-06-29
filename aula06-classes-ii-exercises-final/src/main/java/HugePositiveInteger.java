import java.util.Arrays;

/**
 * Abstraction of an Integer with arbitrary precision.
 */
public class HugePositiveInteger {

    private final char[] digits;

    public HugePositiveInteger() {
        digits = Long.toString(0).toCharArray();
    }

    public HugePositiveInteger(long value) {
        digits = Long.toString(value).toCharArray();
    }

    public HugePositiveInteger(HugePositiveInteger value) {
        digits = Arrays.copyOf(value.digits, value.digits.length);
    }

    /**
     * Create an instance from an array of characters containing digits.
     *
     * @param chars the input array
     * @throws IllegalArgumentException thrown if the input array contains invalid chars
     */
    public HugePositiveInteger(char[] chars) {
        checkDigits(chars);
        digits = trimLeftZeroes(chars);
    }

    /**
     * Create an instance from a String of digits.
     *
     * @param value the string of digits
     */
    public HugePositiveInteger(String value) {
        var chars = value.toCharArray();

        checkDigits(chars);
        digits = trimLeftZeroes(chars);
    }

    private void checkDigits(char[] chars) {
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(String.format("%s is not a digit", c));
            }
        }
    }

    /**
     * Remove left-trailing zeroes.
     *
     * @param digits the array of digits
     * @return the array of digits without trailing zeroes
     */
    private char[] trimLeftZeroes(char[] digits) {
        int i = 0;

        while (i < digits.length - 1 && digits[i] == '0') {
            i++;
        }

        if (i > 0) {
            return Arrays.copyOfRange(digits, i, digits.length);
        }

        return digits;
    }

    /**
     * Get the quantity of digits.
     *
     * @return the quantity of digits
     */
    private int size() {
        return digits.length;
    }

    /**
     * Add two LargeIntegers (the current one plus another one).
     *
     * @param value the other LargeInteger
     * @return a new LargeInteger resulting from the addition
     */
    public HugePositiveInteger plus(HugePositiveInteger value) {
        return new HugePositiveInteger(plus(this.digits, value.digits));
    }

    private char[] plus(char[] a, char[] b) {
        var carry = 0;
        var c = new char[Math.max(a.length, b.length)];
        var i = a.length - 1;
        var j = b.length - 1;
        var k = c.length - 1;

        Arrays.fill(c, '0');

        while (i >= 0 && j >= 0) {
            var sum = Character.digit(a[i], 10)
                + Character.digit(b[j], 10) + carry;

            c[k] = Character.forDigit(sum % 10, 10);
            carry = sum / 10;
            i--;
            j--;
            k--;
        }
        // dump remaining digits for 'a'
        while (i >= 0) {
            var sum = Character.digit(a[i], 10) + carry;

            c[k] = Character.forDigit(sum % 10, 10);
            carry = sum / 10;
            i--;
            k--;
        }
        // dump remaining digits for 'b'
        while (j >= 0) {
            var sum = Character.digit(b[j], 10) + carry;

            c[k] = Character.forDigit(sum % 10, 10);
            carry = sum / 10;
            j--;
            k--;
        }
        // include the overflow, if any
        if (carry > 0) {
            return prepend(Character.forDigit(carry, 10), c);
        }

        return c;
    }

    private char[] prepend(char c, char[] a) {
        var r = new char[a.length + 1];

        r[0] = c;

        for (var i = 1; i < r.length; i++) {
            r[i] = a[i - 1];
        }

        return r;
    }

    /**
     * Generate the 9s complement of the LargeInteger.
     *
     * @return the 9s complement
     */
    public HugePositiveInteger ninesComplement() {
        return new HugePositiveInteger(ninesComplement(digits));
    }

    private char[] ninesComplement(char[] digits) {
        char[] aux = new char[digits.length];

        for (int i = 0; i < digits.length; i++) {
            aux[i] = Character.forDigit(9 - Character.digit(digits[i], 10), 10);
        }

        return aux;
    }

    /**
     * Subtraction between two LargeIntegers. Always subtracts the smallest from the largest (i.e.
     * never generates negative results).
     *
     * @param value the right operand of the subtraction
     * @return the subtraction result
     */
    public HugePositiveInteger minus(HugePositiveInteger value) {
        HugePositiveInteger a;
        HugePositiveInteger b;

        if (this.compareTo(value) == 1) {
            a = this;
            b = value;
        } else {
            a = value;
            b = this;
        }

        return new HugePositiveInteger(ninesComplement(plus(ninesComplement(a.digits), b.digits)));
    }

    /**
     * Compares two LargeIntegers. Return values: - a positive number if left is greater than right
     * - a negative number if left is less than right - zero if left and right are equal
     *
     * @param value the left operand of the comparison
     * @return an integer representing the comparison result
     */
    public int compareTo(HugePositiveInteger value) {
        if (digits.length > value.size()) {
            return 1;
        } else if (digits.length < value.size()) {
            return -1;
        } else {
            for (int i = 0; i < digits.length; i++) {
                var a = Character.digit(digits[i], 10);
                var b = Character.digit(value.digits[i], 10);
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;
                }
            }
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HugePositiveInteger that = (HugePositiveInteger) o;

        return compareTo(that) == 0;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(digits);
    }

    /**
     * Generate a string representation of the LargeInteger.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        var sb = new StringBuilder();
        int i = 0;

        while (i < digits.length) {
            sb.append(digits[i]);
            i++;
        }

        return sb.toString();
    }
}
