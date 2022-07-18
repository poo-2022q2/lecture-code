import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntStackTest {

    private IntStack stack;

    @BeforeEach
    public void setUp() {
        stack = new IntStack(5);
    }

    @Test
    public void testEmptyExceptionOnPop() {
        Assertions.assertThrows(StackEmptyException.class, stack::pop);
    }

    @Test
    public void testFullExceptionOnPush() {
        Assertions.assertThrows(StackFullException.class, () -> {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
        });
    }

    @Test
    public void testFull() {
        for (int i = 0; i < 5; i++) {
            Assertions.assertFalse(stack.isFull());
            stack.push(i);
        }
        Assertions.assertTrue(stack.isFull());
    }

    @Test
    public void testEmpty() {
        Assertions.assertTrue(stack.isEmpty());
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[]", stack.toString());
        stack.push(1);
        Assertions.assertEquals("[1]", stack.toString());
        stack.push(2);
        Assertions.assertEquals("[1,2]", stack.toString());
        stack.push(3);
        Assertions.assertEquals("[1,2,3]", stack.toString());
    }

    @Test
    public void testPush() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            Assertions.assertEquals(i, stack.size());
        }
    }

    @Test
    public void testEmptyExceptionOnPeek() {
        Assertions.assertThrows(StackEmptyException.class, stack::peek);
    }

    @Test
    public void testPeek() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            Assertions.assertEquals(i, stack.peek());
        }
    }

    @Test
    public void testPop() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        for (int i = 5; i >= 1; i--) {
            Assertions.assertEquals(i, stack.size());
            Assertions.assertEquals(i, stack.pop());
        }
        Assertions.assertEquals(0, stack.size());
    }
}
