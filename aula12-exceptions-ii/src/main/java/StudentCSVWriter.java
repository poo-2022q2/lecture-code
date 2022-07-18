import java.io.FileWriter;
import java.io.IOException;

public class StudentCSVWriter {
    private final String fileName;
    private final String separator;

    public StudentCSVWriter(String filename, String separator) {
        this.fileName = filename;
        this.separator = separator;
    }

    public void writeAll(Student[] students) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.toCSV(separator));
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not write to the students file", e);
        }
    }

    public void write(Student student) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(student.toCSV(separator));
        } catch (IOException e) {
            throw new RuntimeException("Could not write to students file", e);
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("Joao", "Silva", 10.0),
                new Student("Mariana", "Ribeiro", 9.9),
                new Student("Francisco", "Dornelles", 5.1),
                new Student("Rebeca", "Ortega", 2.2)
        };
        StudentCSVWriter writer = new StudentCSVWriter(StudentCSVUtil.csvFile, StudentCSVUtil.separator);

        writer.writeAll(students);
        writer.write(new Student("Caio", "Abreu", 7.4));
    }
}
