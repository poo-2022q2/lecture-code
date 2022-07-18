import java.util.ArrayList;
import java.util.Random;

public final class ArrayListDemo {
    private ArrayListDemo() {

    }

    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();

        intArray.add(1);
        intArray.add(2);
        intArray.add(10);

        System.out.println(intArray);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            intArray.add(random.nextInt(100));
        }

        System.out.println(intArray);

        System.out.println(intArray.get(intArray.size()-1));

        ArrayList<Double> doubleArray = new ArrayList<>();

        doubleArray.add(2.3);
        doubleArray.add(3.4);

        System.out.println(doubleArray);

        ArrayList<String> stringArray = new ArrayList<>();

        stringArray.add("hello");
        stringArray.add("world");

        System.out.println(stringArray);
        System.out.println(stringArray.get(0));


    }
}
