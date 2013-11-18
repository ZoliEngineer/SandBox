import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Format an RGB value (three 1-byte numbers) as a 6-digit hexadecimal string.
 *
 * @author ZoliEngineer
 *
 */
public class RgbConverter {

    public static String asHexaComplex(int r, int g, int b) {
        return asHexa(r) + asHexa(g) + asHexa(b);
    }

    public static String asHexaSimple(int r, int g, int b) {
        return String.format("%02X%02X%02X", r, g, b);
    }

    private static String asHexa(int i) {
        String hexa = Integer.toHexString(i).toUpperCase();
        return hexa.length() == 2 ? hexa : 0 + hexa;
    }

    @Test
    public void returnsProperHexaForRGBIntegers() {
        assertEquals("FF6400", asHexaSimple(255, 100, 0));
        assertEquals("FF6400", asHexaComplex(255, 100, 0));
    }
}
