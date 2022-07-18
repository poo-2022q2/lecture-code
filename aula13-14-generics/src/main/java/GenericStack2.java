import java.util.ArrayList;
import java.util.List;

public class GenericStack2<T> {
    private final List<T> elements;

    public GenericStack2() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public void push(T value) {
        elements.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }

        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty. No element to show");
        }
        return elements.get(elements.size()-1);
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
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i));
            if (i < elements.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        GenericStack2<Integer> integerStack = new GenericStack2<>();

        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(40);
        System.out.println(integerStack);


        GenericStack2<Double> doubleStack = new GenericStack2<>();

        doubleStack.push(Math.PI);
        doubleStack.push(Math.E);

        System.out.println(doubleStack);
    }
}
