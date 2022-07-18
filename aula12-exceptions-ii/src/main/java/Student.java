import java.util.Locale;

public class Student {
    private final String firstName;
    private final String lastName;
    private final double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String toCSV(String separator) {
        return String.join(separator, firstName, lastName,
                String.format(Locale.US, "%.3f", grade)) + "\n";
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n"
                + String.format("Grade: %.3f\n", grade);
    }
}
