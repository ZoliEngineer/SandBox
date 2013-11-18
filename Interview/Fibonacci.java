import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Write function to compute Nth fibonacci number
 * 
 * @author ZoliEngineer
 *
 */
public class Fibonacci {

    public int fibonacciForIterative(int n) {
        if (n < 2) {
            return n;
        }
        int currentFibonacci = 1;
        int previousFibonacci = 0;

        for (int i = 1; i < n; i++) {
            int temp = currentFibonacci;
            currentFibonacci = previousFibonacci + currentFibonacci;
            previousFibonacci = temp;
        }
        return currentFibonacci;
    }

    public int fibonacciForRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciForRecursive(n - 2) + fibonacciForRecursive(n - 1);

    }

    @Test
    public void testIterative(){
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacciForIterative(i));
        }

        assertEquals(0, fibonacciForIterative(0));
        assertEquals(1, fibonacciForIterative(1));
        assertEquals(1, fibonacciForIterative(2));
        assertEquals(2, fibonacciForIterative(3));
        assertEquals(3, fibonacciForIterative(4));
        assertEquals(5, fibonacciForIterative(5));
        assertEquals(8, fibonacciForIterative(6));
        assertEquals(13, fibonacciForIterative(7));
        assertEquals(102334155, fibonacciForIterative(40));
    }

    @Test
    public void testRecursive() {
        assertEquals(0, fibonacciForRecursive(0));
        assertEquals(1, fibonacciForRecursive(1));
        assertEquals(1, fibonacciForRecursive(2));
        assertEquals(2, fibonacciForRecursive(3));
        assertEquals(3, fibonacciForRecursive(4));
        assertEquals(5, fibonacciForRecursive(5));
        assertEquals(8, fibonacciForRecursive(6));
        assertEquals(13, fibonacciForRecursive(7));
        assertEquals(102334155, fibonacciForRecursive(40));
    }
}

