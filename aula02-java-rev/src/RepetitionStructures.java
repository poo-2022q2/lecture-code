public class RepetitionStructures {
    public static void main(String[] args) {
        int i = 0;

        while (i < 5) {
            System.out.println(i);
            i++;
        }

        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        }

        do {
            System.out.println(i++);
        } while (i < 10);

    }
}
