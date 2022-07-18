/**
 * A stack that store double values.
 */
public class DoubleStack {
    private final double[] elements;
    private int top;

    public DoubleStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.elements = new double[size];
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

    public void push(double value) {
        if (isFull()) {
            throw new StackFullException(String.format("Stack is full with %d elements", top + 1));
        }
        elements[++top] = value;
    }

    public double pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return elements[top--];
    }

    public double peek() {
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
            sb.append(String.format("%.2f", elements[i]));
            if (i < top) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleStack stack = new DoubleStack(5);

        // test stack empty verification
        try {
            stack.pop();
        } catch (StackEmptyException e) {
            System.out.println("Stack empty verification: PASSED");
        }

        // test stack full verification
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
        } catch(StackFullException e) {
            System.out.println("Stack full verification test: PASSED");
        }

        // test clear
        stack.clear();
        if (stack.isEmpty()) {
            System.out.println("Clear stack is working: PASSED");
        }

        // test push and toString
        System.out.println("PASSED if we see an int pyramid:");
        System.out.println(stack);
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);

        // test pop and toString()
        System.out.println("PASSED if we see an inverse int pyramid:");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

    }
}
