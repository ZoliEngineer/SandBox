/**
 * Print out the grade-school multiplication table up to 12x12
 *
 * @author ZoliEngineer
 *
 */
public class MultiplicationTable {
    private static final int DEFAULT_SIZE = 12;

    public static void main(String... args) {
        int tableSize = DEFAULT_SIZE;

        try {
            if (args.length > 0) {
                tableSize = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            tableSize = DEFAULT_SIZE;
        }

        printMultiplicationTable(tableSize);

    }

    private static void printMultiplicationTable(int tableSize) {
        for (int i = 1; i <= tableSize; i++) {
            for (int j = 1; j <= tableSize; j++) {
                System.out.print(String.format("%4s", i * j));
            }
            System.out.println("");
        }
    }

}
