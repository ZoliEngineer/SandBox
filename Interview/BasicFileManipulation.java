import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;


public class BasicFileManipulation {
    public static void main(String... args) {
        String fileName = "data.txt";

        writeToFile(fileName, "Hello World");
        readFromFile(fileName);
    }

    public static void readFromFile(String fileName) {
        try (Scanner file = createReader(fileName)) {
            printAllLines(file);
        } catch (IOException e) {
            System.out.println(fileName + " is not found");
        }
    }

    public static void writeToFile(String fileName, String line) {
        try (Writer writer = createWriter(fileName)) {
            writer.write(line);
            writer.append((char) Character.LINE_SEPARATOR);
        } catch (IOException e) {
            System.out.println("Error while creating/opening " + fileName);
        }
    }

    private static void printAllLines(Scanner file) {
        while (file.hasNextLine()) {
            System.out.println(file.nextLine());
        }
    }

    private static Writer createWriter(String fileName) throws IOException {
        return new FileWriter(fileName, true);
        // return new BufferedWriter(new FileWriter(fileName, true));
    }

    private static Scanner createReader(String fileName) throws FileNotFoundException {
        return new Scanner(new FileReader(fileName));
        // return new Scanner(new BufferedReader(new FileReader(fileName)));
    }

}
