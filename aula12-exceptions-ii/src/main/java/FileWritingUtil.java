import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;

public final class FileWritingUtil {
    private FileWritingUtil() {

    }

    public static void main(String[] args) {
        File file = new File("data/notas.csv");

        try {
            if (file.exists()) {
                throw new FileAlreadyExistsException("I am not allowed to overwrite an existing file");
            }
            try (PrintWriter pw = new PrintWriter(file)) {
                String format = "%s %.3f\n";

                pw.printf(format, "Joao Silva", 10.0);
                pw.printf(format, "Mariana Ribeiro", 9.9);
                pw.printf(format, "Francisco Dornelles", 5.1);
                pw.printf(format, "Rebeca Ortega", 2.2);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Failed to create the file in order to write", e);
            }
        } catch (FileAlreadyExistsException e) {
            throw new RuntimeException("The file cannot be overwritten", e);
        }

    }
}
