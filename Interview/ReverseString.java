import junit.framework.Assert;

import org.junit.Test;

public class ReverseString {

    public static String reverseStringIterative(String originalString) {
        if (originalString == null || originalString.length() < 2) {
            return originalString;
        }
        char[] mutableChars = originalString.toCharArray();
        for (int i = 0; i < (mutableChars.length) / 2; i++) {
            swap(mutableChars, i, mutableChars.length - i - 1);
        }
        return String.valueOf(mutableChars);
    }

    public static String reverseStringRecursive(String originalString) {
        if (originalString == null || originalString.length() < 2) {
            return originalString;
        }
        return reverseStringRecursive(originalString.substring(1)) + originalString.charAt(0);
    }


    private static void swap(char[] source, int posX, int posY) {
        char temp = source[posX];
        source[posX] = source[posY];
        source[posY] = temp;
    }

    @Test
    public void testIterative() {
        Assert.assertEquals("654321", reverseStringIterative("123456"));
        Assert.assertEquals("1", reverseStringIterative("1"));
        Assert.assertEquals("", reverseStringIterative(""));
        Assert.assertEquals(null, reverseStringIterative(null));
    }

    @Test
    public void testRecursive() {
        Assert.assertEquals("654321", reverseStringRecursive("123456"));
        Assert.assertEquals("1", reverseStringRecursive("1"));
        Assert.assertEquals("", reverseStringRecursive(""));
        Assert.assertEquals(null, reverseStringRecursive(null));
    }

}
