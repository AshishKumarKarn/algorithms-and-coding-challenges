package com.karn.dsa.heap;

import java.util.*;

public class PQ {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> ne = new TreeMap<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        queue.add(3);
        queue.add(34);
        queue.add(23);
        queue.add(13);
        queue.add(13);
        queue.add(31);
        System.out.println(queue);
        queue.remove(13);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);



    }
}
