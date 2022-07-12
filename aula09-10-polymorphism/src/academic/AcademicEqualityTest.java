package academic;

public class AcademicEqualityTest {
    public static void main(String[] args) {
        Student s1 = new Student("joao", "cardoso", "123", "bcc", 18);
        Student s2 = new Student("joao", "cardoso", "123", "bcc", 18);

        System.out.println(s1.equals(s2));
    }
}
