package pro.pfilaretov.ti.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class BiggestCommonSubSequence {

    public static void main(String[] args) {
        String a = "abcdefghab";
        String b = "ababc";

        String result = subsequence(a, b);
        System.out.println("result: " + result);
    }

    private static String subsequence(String string1, String string2) {
        // 1. put string1 to a map of (char->indices)
        Map<Character, Set<Integer>> chars = new HashMap<>();

        char[] aArray = string1.toCharArray();
        for (int i = 0; i < aArray.length; i++) {
            char c = aArray[i];
            Set<Integer> indices = chars.get(c);
            if (indices == null) {
                indices = new HashSet<>();
            }

            indices.add(i);
            chars.put(c, indices);
        }

        System.out.println("chars: " + chars);

        // 2. iterate string2 and look for indices

        StringBuilder result = new StringBuilder();

        char[] bArray = string2.toCharArray();
        Set<Integer> currentIndices;
        Set<Integer> previousIndices = null;
        for (int i = 0; i < bArray.length; i++) {
            // TODO - create result here?

            char c = bArray[i]; // 'b'
            currentIndices = chars.get(c); // [1, 9]
            if (currentIndices == null) {
                continue;
            }

            if (previousIndices != null) {
                // c: 'b'
                // previousIndices: [0, 8]
                // currentIndices:  [1, 9]
                for (int previous : previousIndices) {
                    if (currentIndices.contains(previous + 1)) {
                        result.append(c);
                    }
                }
            }

            previousIndices = currentIndices;
        }

        // TODO
        return null;
    }
}
