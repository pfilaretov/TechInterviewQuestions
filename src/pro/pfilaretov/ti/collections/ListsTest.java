package pro.pfilaretov.ti.collections;

import java.util.Collections;
import java.util.List;

public class ListsTest {

    public static void main(String[] args) {
        List<String> strings = Collections.singletonList("Hello!");
        System.out.println("strings: " + strings);

        strings.add("I'm here!");
        System.out.println("new strings: " + strings);
    }
}
