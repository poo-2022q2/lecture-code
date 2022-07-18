import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class StudentCSVReader {
    private final String filename;
    private final String separator;

    public StudentCSVReader(String filename, String separator) {
        this.filename = filename;
        this.separator = separator;
    }

    private int countStudents() {
        int qtyStudents = 0;

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                qtyStudents++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not read the input file", e);
        }

        return qtyStudents;
    }

    public Student[] readAll() {
        Student[] students = new Student[countStudents()];

        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.useLocale(Locale.US);
            scanner.useDelimiter(String.format("[%s\\n]", separator));
            for (int i = 0; i < students.length; i++) {
                students[i] = new Student(scanner.next(), scanner.next(), scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not read the input file", e);
        } catch (InputMismatchException e) {
            throw new RuntimeException("Could not parse grade value", e);
        }

        return students;
    }

    public static void main(String[] args) {
        StudentCSVReader reader = new StudentCSVReader(StudentCSVUtil.csvFile, StudentCSVUtil.separator);

        for (Student student : reader.readAll()) {
            System.out.println(student);
        }
    }

}
