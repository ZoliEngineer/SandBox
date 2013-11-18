
/**
 * Returns the given bit from the binary format of the given integer
 * 
 * @author ZoliEngineer
 *
 */
public class BitReader {
    public static void main(String... args) {
        int i = 8; //0b1000;
        int position = 3;
        boolean b = getBitAtPosition(position, i);
        System.out.println(b);

    }

    private static boolean getBitAtPosition(int pos, int number) {
        int mask = 1 << pos;
        return (mask ^ number) == 0;
    }
}
