package pro.pfilaretov.ti.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListsTest {

    public static void main(String[] args) {
        List<String> strings = Collections.singletonList("Hello!");
        System.out.println("strings: " + strings);

        // UnsupportedOperationException
//        strings.add("I'm here!");
//        System.out.println("new strings: " + strings);

        checkArrayListCapacity();
    }

    private static void checkArrayListCapacity() {
        // OutOfMemoryError: Requested array size exceeds VM limit
        //List<Byte> bigList = new ArrayList<>(Integer.MAX_VALUE);
        List<Byte> bigList = new ArrayList<>(Integer.MAX_VALUE / 2);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // OutOfMemoryError: Java heap space
            bigList.add((byte) 0);
            if (i % 1e8 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("bigList.size=" + bigList.size());

        bigList.add((byte) 1);
        System.out.println("bigList.size=" + bigList.size());
    }
}
