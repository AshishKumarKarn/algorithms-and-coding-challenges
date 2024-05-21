package com.karn.interview.microsoft;

public class ReverseKNodesAfterNIntervals {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = head.next = new ListNode(2);
        next = next.next = new ListNode(3);
        next = next.next = new ListNode(4);
        next = next.next = new ListNode(5);


        print(head);
        ListNode reversed = new ReverseKNodesAfterNIntervals().reverse(head, 4, 4);
        print(reversed);
        //3 -> 2 -> 1 -> 4 -> 5 -> 8 -> 7 -> 6 -> 9 -> 10 -> 13 -> 12 -> 11 -> 14 -> null
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node);
            node = node.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head, int k, int n) {
        ListNode node = head;
        ListNode startNode = head;
        ListNode endNode = head;
        ListNode newHead = null;
        ListNode prevNode = null;
        while (node != null) {
            int currentK = k;
            int currentN = n;

            ListNode prevEndNode = null;
            while (currentK > 1) {
                if(endNode.next==null) break;
                prevEndNode = endNode;
                endNode = endNode.next;
                currentK--;
            }
            ListNode nHead = reverseLN(prevNode, startNode, prevEndNode, endNode, endNode.next);
            if(newHead==null){
                newHead = nHead;
            }

            while (currentN > 1) {
                prevNode = node;
                node = node.next;
                if (node == null) {
                    break;
                }
                currentN--;
            }
            endNode = node;
            startNode = node;


        }

        return newHead;
    }

    private ListNode reverseLN(ListNode prevNode, ListNode startNode,ListNode prevEndNode, ListNode endNode, ListNode next) {
        if (prevNode != null) {
            prevNode.next = endNode;
        }
        ListNode tempStart = startNode;
        while (startNode!=null&&startNode != endNode) {
            ListNode nextNode = startNode.next;
            ListNode nextToNextNode = null;
            if (startNode.next!=null) {
                nextToNextNode = startNode.next.next;
                startNode.next = nextNode.next;
                nextNode.next = startNode;
            }
            startNode = nextToNextNode;
        }
        endNode.next = prevEndNode;
        tempStart.next = next;

        return startNode;
    }
}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + " -> ";
    }
}