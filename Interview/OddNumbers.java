/**
 * Write function to print the odd numbers from 1 to 99
 *
 * @author ZoliEngineer
 *
 */
public class OddNumbers {

    public static void main(String... args) {
        printOddNumbers(99);
    }

    public static void printOddNumbers(int boundary) {
        for (int i = 1; i <= boundary; i += 2) {
                System.out.println(i);

        }
    }

    // Obsolete
    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
