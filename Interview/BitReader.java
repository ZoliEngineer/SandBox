import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Bits and bytes questions
 *
 * @author ZoliEngineer
 *
 */
public class BitReader {

    /**
     * How do you test whether the high-order bit is set in a byte?
     *
     * @param b
     * @return
     */
    public static boolean isHighOrderBitSet(byte b) {
        int mask = 1 << 6;
        return (b & mask) == mask;
    }

    /**
     * Write a function to count all the bits in an int value
     *
     * @param n
     * @return
     */
    public static int countBits(int n) {
        if (n == 0) {
            return 0;
        }
        int lowOrderBitMask = 1;

        return (n & lowOrderBitMask) + countBits(n >> 1);
    }

    /**
     * Describe a function that takes an int value and returns true if the bit pattern of that int value is the same if you
     * reverse it (i.e. it's a palindrome)
     *
     * @param n
     * @return
     */
    public static boolean isBitPalindrom(int n) {
        int original = n;
        int x = n;

        int reverse = 0;
        while (x != 0) {
            reverse <<= 1;
            reverse |= (x & 1);
            x >>>= 1;
        }
        return original == reverse;
    }

    @Test
    public void testCountBits() {
        assertEquals(0, countBits(0b00000));
        assertEquals(1, countBits(0b00001));
        assertEquals(4, countBits(0b10101010));
        assertEquals(31, countBits(0b1111111111111111111111111111111));
        assertEquals(31, countBits(Integer.MAX_VALUE));

    }

    @Test
    public void testHighOrderBitSet() {
        assertFalse(isHighOrderBitSet((byte) 0));
        assertFalse(isHighOrderBitSet((byte) 0b0111111));
        assertTrue(isHighOrderBitSet((byte) 0b1000000));
        assertTrue(isHighOrderBitSet(Byte.MAX_VALUE));
    }

    @Test
    public void testBinaryPalindrom() {
        assertTrue(isBitPalindrom(0b0000000));
        assertTrue(isBitPalindrom(0b1111111));
        assertTrue(isBitPalindrom(0b100001));
        assertTrue(isBitPalindrom(0b1110111));
        assertFalse(isBitPalindrom(0b1000000));
        assertTrue(isBitPalindrom(1));
        assertFalse(isBitPalindrom(0b0000100));
    }
}
