package com.karn.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        ListNode listNode = null;
        ListNode head = null;
        ListNode head2 = null;
        for (int a : arr) {
            if (listNode == null) {
                listNode = new ListNode(a);
                head = listNode;
                head2 = listNode;
            } else {
                listNode.next = new ListNode(a);
                listNode = listNode.next;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
        listNode = new RemoveDuplicatesFromSortedListII()
                .deleteDuplicates(head2);
        sb = new StringBuilder();
        sb.append("[");
        head = listNode;
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());

    }

    static class ListNode {
        int val;
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
            return this.val + "";
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        stack.push(head.val);
        return delete(head);
    }

    private ListNode delete(ListNode node) {
        ListNode answer = null;
        ListNode result = null;
        ListNode hold = null;
        boolean first = true;
        while (node != null) {
            Integer peek = stack.peek();
            if (node.val != peek || first) {
                first = false;
                if (hold != null) {
                    if (result == null) {
                        result = new ListNode(hold.val);
                        answer = result;
                    } else {
                        result.next = new ListNode(hold.val);
                        result = result.next;
                    }
                }
                hold = node;
            } else if (hold != null) {
                hold = null;
            }
            stack.push(node.val);
            node = node.next;
        }
        if (hold != null) {
            if (result != null)
                result.next = hold;
            else
                return hold;
        }

        return answer;
    }

    private final Stack<Integer> stack = new Stack<>();


}