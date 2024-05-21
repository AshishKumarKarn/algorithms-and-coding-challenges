package com.karn.algosolutions;

import java.util.*;

public class EfficientDataStructure {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double v = sc.nextDouble();
        EfficientDataStructure dataStructure = new EfficientDataStructure();
        dataStructure.store(2);
        dataStructure.store(3);
        dataStructure.store(5);
        dataStructure.store(6);
        dataStructure.store(1);
        System.out.println(dataStructure);
        dataStructure.delete(6);
        System.out.println(dataStructure);
        dataStructure.delete(2);
        System.out.println(dataStructure.random());
        System.out.println(dataStructure);


    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object obj) {
            return this.val == ((ListNode) obj).val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    private final Map<Integer, ListNode> valueToNodes = new HashMap<>();//value to listNode
    private final Map<ListNode, Integer> nodeToIndexMap = new HashMap<>();// listNode to Index

    private final ListNode[] nodeArray = new ListNode[10_000_000];
    private ListNode head;
    private ListNode currentNode;
    private int length;

    public void store(int value) {
        if (valueToNodes.containsKey(value)) {
            throw new IllegalArgumentException("Element with this value is already present");
        }
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            currentNode = head;
            valueToNodes.put(value, currentNode);
            nodeToIndexMap.put(newNode, length);
            nodeArray[length]= newNode;
            length++;
            return;
        }

        currentNode.next = newNode;
        ListNode lastNode = currentNode;
        currentNode = currentNode.next;
        currentNode.prev = lastNode;
        valueToNodes.put(value, currentNode);
        nodeToIndexMap.put(newNode, length);
        nodeArray[length]= newNode;
        length++;
    }

    public void delete(int value) {
        if (head == null) {
            throw new IllegalStateException("Empty data structure");
        }
        if (!valueToNodes.containsKey(value)) {
            throw new NoSuchElementException("Element not found");
        }

        ListNode toBeDeleted = valueToNodes.get(value);
        Integer existingIndex = nodeToIndexMap.get(toBeDeleted);

        ListNode lastNode = currentNode;


        ListNode prev = toBeDeleted.prev;
        ListNode next = toBeDeleted.next;
        if (prev != null) {
            prev.next = lastNode;
        }
        if (next != null) {
            next.prev = prev;
        }


        nodeToIndexMap.put(lastNode, existingIndex);
        nodeArray[existingIndex] = lastNode;

        nodeToIndexMap.remove(toBeDeleted);
        valueToNodes.remove(value);
        nodeArray[length-1] = null; //optional
        length--;
        head = nodeArray[0];
    }

    public int random() {
        int i = (int) (Math.random() * (length));
        return (nodeArray[i]).val;
    }

    @Override
    public String toString() {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while(node!=null){
            sb.append(node.val).append(" -> ");
            node = node.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
