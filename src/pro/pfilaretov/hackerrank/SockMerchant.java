package pro.pfilaretov.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        if (n < 2) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer colour = ar[i];
            Integer count = map.get(colour);
            count = count == null ? 1 : count + 1;
            map.put(colour, count);
        }

        return map.values().stream().mapToInt(v -> v.intValue() / 2).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int result = sockMerchant(9, new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20});

        System.out.println("result: " + result);
    }
}
