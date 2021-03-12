package pro.pfilaretov.ti.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Several ways to calculate Fibonacci numbers
 */
public class Fibonacci {

    public static void main(String[] args) {
        long n = 42;
        long result = 0;
        long start;
        long end;

        /*
        start = System.nanoTime();
        result = recursiveFibonacci(n);
        end = System.nanoTime();
        System.out.println("recursive Fibonacci(" + n + ") = " + result);
        System.out.println("done in " + (end - start)/1000000 + " ms");
        System.out.println("=================================");
        System.out.println();
        */
        /*
        start = System.nanoTime();
        result = recursiveFibonacciOptimized(n);
        end = System.nanoTime();
        System.out.println("recursive Fibonacci optimized(" + n + ") = " + result);
        System.out.println("done in " + (end - start)/1000000 + " ms");
        System.out.println("=================================");
        System.out.println();
        */

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            result = linearFibonacci(i);
            System.out.println("linear Fibonacci (" + i + ") = " + result);
        }
        end = System.nanoTime();
//        System.out.println("linear Fibonacci (" + n + ") = " + result);
        System.out.println("done in " + (end - start) / 1000000 + " ms");
        System.out.println("=================================");
        System.out.println();

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            result = candidatesFibonacci(i);
            System.out.println("linear Fibonacci 2(" + i + ") = " + result);
        }
        end = System.nanoTime();
//        System.out.println("linear Fibonacci 2(" + n + ") = " + result);
        System.out.println("done in " + (end - start) / 1000000 + " ms");
        System.out.println("=================================");
        System.out.println();

    }

    private static long recursiveFibonacci(long n) {
        if (n <= 1) {
            return n;
        }

        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    private static Map<Long, Long> recursiveMap = new HashMap<>();

    private static long recursiveFibonacciOptimized(long n) {
        if (recursiveMap.get(n) != null) {
            return recursiveMap.get(n);
        }

        if (n <= 1) {
            return n;
        }

        long n2 = recursiveFibonacciOptimized(n - 2);
        recursiveMap.put(n - 2, n2);

        long n1 = recursiveFibonacciOptimized(n - 1);
        recursiveMap.put(n - 1, n1);

        return n1 + n2;
    }


    private static Map<Long, Long> linearMap = new HashMap<>();

    private static long linearFibonacciWithMap(long n) {
        linearMap.put(0L, 0L);
        linearMap.put(1L, 1L);

        long result = n;
        for (long i = 2; i <= n; i++) {
            result = linearMap.get(i - 1) + linearMap.get(i - 2);
            linearMap.put(i, result);
        }

        return result;
    }

    private static long linearFibonacci(long n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        long n1 = 0;
        long n2 = 1;
        long n3 = 0;

        while (n-- > 1) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        return n3;
    }

    private static long linearFibonacci2(long n) {
        if (n < 2) {
            return n;
        }

        long i1 = 0;
        long i2 = 1;
        long result = 0;
        for (long i = 1; i < n; i++) {
            result = i1 + i2;
            i1 = i2;
            i2 = result;
        }

        return result;
    }

    private static long candidatesFibonacci(long index) {
        if (index <= 0) {
            return 0;
        }

        if (index <= 2) {
            return 1;
        }

        int num1 = 1;
        int num2 = 1;
        for (long i = 3; i <= index; i++) {
            if (i % 2 == 0) {
                num2 += num1;
            } else {
                num1 += num2;
            }
        }

        return num1 > num2 ? num1 : num2;
    }
}
