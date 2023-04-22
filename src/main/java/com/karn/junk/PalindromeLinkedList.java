package com.karn.junk;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        Thread.sleep(10000);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        Integer integer = set.stream().findAny().get();
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            if (!stk.empty() && stk.peek().equals(list.get(i))) {
                stk.pop();
            } else if (stk.empty() || !stk.peek().equals(list.get(i))) {
                stk.add(list.get(i));
            }
        }
        if (stk.empty()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
