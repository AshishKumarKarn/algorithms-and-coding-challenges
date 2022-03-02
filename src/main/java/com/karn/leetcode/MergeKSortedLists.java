package com.karn.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] la = new ListNode[3];
        la[0] = l1;
        la[1] = l2;
        la[2] = l3;

        System.out.println(new MergeKSortedLists().mergeKLists(la));


    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> collect = Arrays.stream(lists).flatMap(a -> {
            List<Integer> list=new ArrayList<>();
            while(a!=null){
                list.add(a.val);
                a=a.next;
            }
            return list.stream();
        }).sorted().collect(Collectors.toList());
        ListNode finalNodes = null;
        ListNode resultHead = null;
        for (Integer integer : collect) {
            if (finalNodes != null) {
                finalNodes.next = new ListNode(integer);
                finalNodes = finalNodes.next;
            } else {
                resultHead = new ListNode(integer);
                finalNodes = resultHead;
            }
        }
        return resultHead;
    }

    static class ListNode {
        Integer val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.val);
            while (this.next != null) {
                sb.append(" ,");
                this.val = next.val;
                this.next = next.next;
                sb.append(this.val);
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
