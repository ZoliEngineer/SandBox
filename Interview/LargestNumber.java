
/**
 * Find the largest int value in an int array
 *
 * @author ZoliEngineer
 *
 */
public class LargestNumber {
    public static void main(String... args) {
        int[] array = new int[] { 0, 3, 5, 2, 7, 1, 3, 2 };
        int largest = findLargest(array);
        System.out.println(largest);

    }

    private static int findLargest(int[] array) {
        int tempLargest = 0;
        for (int i : array) {
            tempLargest = i > tempLargest ? i : tempLargest;
        }
        return tempLargest;
    }

}
