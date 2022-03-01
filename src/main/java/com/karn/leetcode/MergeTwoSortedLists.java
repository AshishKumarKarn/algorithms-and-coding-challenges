package com.karn.leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        System.out.println(listNode);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode listNode = new ListNode();
        ListNode resultNode = listNode;
        boolean l1 = list1.val < list2.val;
        if (l1) {
            listNode.val = list1.val;
            list1 = list1.next;
        } else {
            listNode.val = list2.val;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            listNode.next = new ListNode();
            listNode = listNode.next;
            l1 = list1.val < list2.val;
            if (l1) {
                listNode.val = list1.val;
                list1 = list1.next;
            } else {
                listNode.val = list2.val;
                list2 = list2.next;
            }

        }
        while (list1 != null) {
            listNode.next = new ListNode();
            listNode = listNode.next;
            listNode.val = list1.val;
            list1 = list1.next;

        }
        while (list2 != null) {
            listNode.next = new ListNode();
            listNode = listNode.next;
            listNode.val = list2.val;
            list2 = list2.next;
        }
        return resultNode;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            sb.append("[");
            sb.append(this.val);
            while (this.next!=null){
                sb.append(" ,");
                this.val=next.val;
                this.next=next.next;
                sb.append(this.val);
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
