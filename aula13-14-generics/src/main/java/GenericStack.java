public class GenericStack<T> {
    private final T[] elements;
    private int top;

    public GenericStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        // XXX: workaround for generic arrays
        elements = (T[]) new Object[size];
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

    public void push(T value) {
        if (isFull()) {
            throw new StackFullException(String.format("Stack is full with %d elements", top + 1));
        }
        elements[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return elements[top--];
    }

    public T peek() {
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
        GenericStack<Integer> integerStack = new GenericStack<>(3);

        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(40);
        System.out.println(integerStack);


        GenericStack<Double> doubleStack = new GenericStack<>(3);

        doubleStack.push(Math.PI);
        doubleStack.push(Math.E);

        System.out.println(doubleStack);
    }
}
