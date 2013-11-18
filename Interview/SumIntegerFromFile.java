import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * Write function that sums up integers from a text file, one per line
 *
 * @author ZoliEngineer
 *
 */
public class SumIntegerFromFile {
    public static void main(String... args) {
        String fileName = "integers.txt"; 

        calculateSum(fileName);
    }

    // TODO: exception handling for NumberFormatException
    // TODO: code cleaning by extracting inner methods
    private static void calculateSum(String fileName) {
        int sum = 0;
        try (Scanner file = new Scanner(new FileReader(fileName))) {
            while (file.hasNextLine()) {
                sum += Integer.parseInt(file.nextLine());
            }
        } catch (IOException e) {
            System.out.println(fileName + " is not found");
        }
        System.out.println(sum);
    }
}
