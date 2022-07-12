package academic;

import java.util.Arrays;

public class AcademicComparisonTest {
    public static void main(String[] args) {
        Student s1 = new Student("joao", "cardoso", "123", "bcc", 21);
        Student s2 = new Student("maria", "nogueira", "567", "bcc", 23);
        Student s3 = new Student("joana", "pedrosa", "383", "bcc", 20);

        Student[] students = new Student[] {s1, s2, s3};

        System.out.println(Arrays.toString(students));
        System.out.println();

        Arrays.sort(students);

        System.out.println(Arrays.toString(students));
    }
}
