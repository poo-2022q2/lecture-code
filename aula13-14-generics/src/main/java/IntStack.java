/**
 * A stack that store int values.
 */
public class IntStack {
    private final int[] elements;
    private int top;

    public IntStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.elements = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackFullException(String.format("Stack is full with %d elements", top + 1));
        }
        elements[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return elements[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty. No element to show");
        }
        return elements[top];
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        IntStack intStack = new IntStack(5);

        // test stack empty verification
        try {
            intStack.pop();
        } catch (StackEmptyException e) {
            System.out.println("Stack empty verification: PASSED");
        }

        // test stack full verification
        try {
            intStack.push(1);
            intStack.push(2);
            intStack.push(3);
            intStack.push(4);
            intStack.push(5);
            intStack.push(6);
        } catch(StackFullException e) {
            System.out.println("Stack full verification test: PASSED");
        }

        // test clear
        intStack.clear();
        if (intStack.isEmpty()) {
            System.out.println("Clear stack is working: PASSED");
        }

        // test push and toString
        System.out.println("PASSED if we see an int pyramid:");
        System.out.println(intStack);
        intStack.push(1);
        System.out.println(intStack);
        intStack.push(2);
        System.out.println(intStack);
        intStack.push(3);
        System.out.println(intStack);
        intStack.push(4);
        System.out.println(intStack);
        intStack.push(5);
        System.out.println(intStack);

        // test pop and toString()
        System.out.println("PASSED if we see an inverse int pyramid:");
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);

    }
}
