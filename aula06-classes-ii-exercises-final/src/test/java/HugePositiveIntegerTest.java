import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for LargeInteger.
 */
public class HugePositiveIntegerTest {

    private static final String rationalTestCases = "src/test/resources/huge-positive-integer.csv";
    private final List<TestRecord> testRecords;

    private static class TestRecord {

        public final String strA;
        public final String strB;
        public final HugePositiveInteger aa;
        public final HugePositiveInteger bb;
        public final HugePositiveInteger complementA;
        public final HugePositiveInteger complementB;
        public final int compareAb;
        public final int compareBa;
        public final HugePositiveInteger plusAb;
        public final HugePositiveInteger plusBa;
        public final HugePositiveInteger minusAb;
        public final HugePositiveInteger minusBa;

        public TestRecord(String strA, String strB, HugePositiveInteger aa, HugePositiveInteger bb,
            HugePositiveInteger complementA,
            HugePositiveInteger complementB, int compareAb, int compareBa,
            HugePositiveInteger plusAb,
            HugePositiveInteger plusBa,
            HugePositiveInteger minusAb, HugePositiveInteger minusBa) {
            this.strA = strA;
            this.strB = strB;
            this.aa = aa;
            this.bb = bb;
            this.complementA = complementA;
            this.complementB = complementB;
            this.compareAb = compareAb;
            this.compareBa = compareBa;
            this.plusAb = plusAb;
            this.plusBa = plusBa;
            this.minusAb = minusAb;
            this.minusBa = minusBa;
        }
    }

    /**
     * Constructor.
     */
    public HugePositiveIntegerTest() {
        testRecords = new ArrayList<>();
        try (var scanner = new Scanner(new File(rationalTestCases))) {
            while (scanner.hasNext()) {
                var strA = scanner.next();
                var strB = scanner.next();
                var a = new HugePositiveInteger(strA);
                var b = new HugePositiveInteger(strB);
                var complementA = new HugePositiveInteger(scanner.next());
                var complementB = new HugePositiveInteger(scanner.next());
                var compareAb = Integer.parseInt(scanner.next());
                var compareBa = Integer.parseInt(scanner.next());
                var plusAb = new HugePositiveInteger(scanner.next());
                var plusBa = new HugePositiveInteger(scanner.next());
                var minusAb = new HugePositiveInteger(scanner.next());
                var minusBa = new HugePositiveInteger(scanner.next());

                testRecords.add(
                    new TestRecord(strA, strB, a, b, complementA, complementB, compareAb, compareBa,
                        plusAb, plusBa, minusAb, minusBa));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNinesComplement() {
        for (var record : testRecords) {
            Assertions.assertEquals(record.complementA, record.aa.ninesComplement(),
                String.format("%s has wrong 9's complement", record.strA));
            Assertions.assertEquals(record.complementB, record.bb.ninesComplement(),
                String.format("%s has wrong 9's complement", record.strB));
        }
    }

    @Test
    public void testComparison() {
        for (var record : testRecords) {
            Assertions
                .assertEquals(record.compareAb,
                    record.aa.compareTo(record.bb),
                    String.format("%s compared to %b lead to wrong result", record.strA,
                        record.strB));
            Assertions
                .assertEquals(record.compareBa,
                    new HugePositiveInteger(record.bb).compareTo(record.aa),
                    String.format("%s compared to %b lead to wrong result", record.strB,
                        record.strA));
        }
    }

    @Test
    public void testAddition() {
        for (var record : testRecords) {
            Assertions.assertEquals(record.plusAb,
                record.aa.plus(record.bb),
                String.format("%s + %s lead to wrong result", record.strA, record.strB));
            Assertions.assertEquals(record.plusBa,
                record.bb.plus(record.aa),
                String.format("%s + %s lead to wrong result", record.strB, record.strA));
        }
    }

    @Test
    public void testSubtraction() {
        for (var record : testRecords) {
            Assertions.assertEquals(record.minusAb,
                record.aa.minus(record.bb),
                String.format("%s - %s lead to wrong result", record.strA, record.strB));
            Assertions.assertEquals(record.minusBa,
                record.bb.minus(record.aa),
                String.format("%s - %s lead to wrong result", record.strB, record.strA));
        }
    }
}
