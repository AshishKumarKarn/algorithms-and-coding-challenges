package com.karn.leetcode;

public class SwapNodesInPairs {

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
    }

 public static void main(String[] args) {
     ListNode head=new ListNode(1);
     head.next=new ListNode(2);
     head.next.next = new ListNode(3);
     head.next.next.next = new ListNode(4);
  new SwapNodesInPairs().swapPairs(head);
 }
    public ListNode swapPairs(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }
        return swapPair(head, head.next, head.next);
    }

    private ListNode swapPair(ListNode node, ListNode next, ListNode head) {
        if (next == null) {
            return head;
        }
        ListNode temp = next.next;
        int tempVal = next.val;
        next.val = node.val;
        next.next = node;
        node.next = temp;
        node.val = tempVal;
        if (temp == null) {
            return head;
        }
        return swapPair(temp, temp.next, head);
    }
}
