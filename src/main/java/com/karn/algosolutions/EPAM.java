package com.karn.algosolutions;

import java.util.*;

public class EPAM {
    public static void main(String[] args) {
//        LinkedList<Integer> list=new LinkedList<>();
//        list.removeFirst();
//        Set<Integer> set=new HashSet<>();
//        set.add(1);
//        Integer integer = set.stream().findFirst().orElse(-1);
//        System.out.println(integer);
//        Stack<Integer> stack = new Stack<>();
//        stack.peek();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);queue.add(2);queue.add(3);
        Queue<Integer> allQ = new LinkedList<>();
        allQ.addAll(queue);
        System.out.println(allQ);
        allQ.clear();
        Stack<Integer> stack=new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(1);


        int[] objects = stack.stream().mapToInt(a->a).toArray();
        System.out.println(Arrays.toString(objects));


    }
}
