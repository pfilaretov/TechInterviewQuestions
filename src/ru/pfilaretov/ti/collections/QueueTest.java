package ru.pfilaretov.ti.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        while (!queue.isEmpty()) {
            Integer i = queue.remove();
            if (i == 2) {
                Collections.addAll(queue, 42, 55, 78);
            }

            System.out.println(i);
        }
    }
}
