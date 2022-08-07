package com.karn.leetcode.leetcode75contest;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode prevNode = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prevNode;
            prevNode = node;
            node = temp;
        }
        return prevNode;
    }

    class ListNode {
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
    }
}
