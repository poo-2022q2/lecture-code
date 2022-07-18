import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public final class FileReadingUtil {

    private FileReadingUtil() {

    }

    public static class FilePermissionException extends IOException {
        public FilePermissionException(String message, File file) {
            super(message + ": " + file);
        }
    }

    public static void main(String[] args) {
        File file = new File("data/notas.csv");

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find file " + file.getName());
            }
            if (!file.canRead()) {
                throw new FilePermissionException("Cannot read file", file);
            }
            try (Scanner scanner = new Scanner(file)) {
                scanner.useLocale(Locale.US);
                while (scanner.hasNext()) {
                    System.out.printf(Locale.US, "%s %s %.3f\n", scanner.next(),
                            scanner.next(), scanner.nextDouble());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Failed to open the file for reading", e);
            } catch (InputMismatchException e) {
                throw new RuntimeException("Failed to convert input data", e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Check if the file is in the the directory. Absolute path: "
                + file.getAbsolutePath(), e);
        } catch (FilePermissionException e) {
            throw new RuntimeException("Failed to read the file", e);
        }
    }
}
