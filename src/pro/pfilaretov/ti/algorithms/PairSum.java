package pro.pfilaretov.ti.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a function that takes two args: a list of integers ("list") and a number ("targetSum"). The function should
 * find and return all pairs such that their sum equals to "targetSum".
 * <p>For instance,</p>
 * <p>list = [1, 2, 3, 4, 5]</p>
 * <p>targetSum = 6</p>
 * <p>result: [[1, 5], [2, 4]]</p>
 * <p/>
 * <p>Solution:</p>
 * <p>- brut force -> O(n^2)</p>
 * <p>- Use Hash Map/Set -> O(n)</p>
 */
public class PairSum {

    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, i -> i + 1).limit(20).collect(Collectors.toList());
        Collections.shuffle(list);
        int targetSum = 12;

        System.out.println("list: " + list);
        System.out.println("targetSum: " + targetSum);

//        List<Pair> pairs = findPairsBrutForce(list, targetSum);
//        List<Pair> pairs = findPairs(list, targetSum);
//        List<Pair> pairs = findPairsHashMap(list, targetSum);
        List<Pair> pairs = findPairsSet(list, targetSum);

        System.out.println("result: " + pairs);
    }

    private static List<Pair> findPairsBrutForce(List<Integer> list, int targetSum) {
        List<Pair> result = new ArrayList<>();
        long operationsCount = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                operationsCount++;
                if (list.get(i) + list.get(j) == targetSum) {
                    result.add(new Pair(list.get(i), list.get(j)));
                }
            }
        }

        System.out.println("list.size=" + list.size() + ", operationsCount=" + operationsCount);

        return result;
    }

    private static List<Pair> findPairs(List<Integer> list, int targetSum) {
        List<Pair> result = new ArrayList<>();
        long operationsCount = 0;

        Set<Integer> wanted = new HashSet<>();

        for (Integer i : list) {
            operationsCount++;
            wanted.add(targetSum - i);
        }
        System.out.println("wanted: " + wanted);

        for (Integer i : list) {
            operationsCount++;
            if (wanted.contains(i)) {
                result.add(new Pair(targetSum - i, i));
            }
        }

        System.out.println("list.size=" + list.size() + ", operationsCount=" + operationsCount);

        return result;
    }

    private static List<Pair> findPairsHashMap(List<Integer> list, int targetSum) {
        List<Pair> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : list) {
            Integer j = map.get(targetSum - i);
            if (j != null) {
                result.add(new Pair(i, j));
            } else {
                map.put(i, i);
            }
        }

        return result;
    }

    private static List<Pair> findPairsSet(List<Integer> list, int targetSum) {
        List<Pair> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (Integer i : list) {
            if (set.contains(targetSum - i)) {
                result.add(new Pair(i, targetSum - i));
            } else {
                set.add(i);
            }
        }

        return result;
    }
}

class Pair {

    private final int a;
    private final int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "{" + a + ", " + b + "}";
    }
}
