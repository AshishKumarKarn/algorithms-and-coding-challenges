package com.karn.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class WriteFastDataStructureClient {
    public static void main(String[] args) {
        FastDataStructure fds = new FastDataStructure();
        fds.addListNode(new ListNode(1));
        fds.addListNode(new ListNode(4));
        fds.addListNode(new ListNode(6));
        fds.addListNode(new ListNode(2));
        fds.addListNode(new ListNode(8));
        fds.addListNode(new ListNode(9));
        fds.addListNode(new ListNode(12));
        fds.addListNode(new ListNode(5));
        System.out.println(fds);
        System.out.println(fds.getMostFrequentlyAccessedNode());
        System.out.println(fds.getNode(8));
        System.out.println(fds.getMostFrequentlyAccessedNode());
        System.out.println(fds.getNode(2));
        System.out.println(fds.getNode(8));
        System.out.println(fds.getNode(12));
        System.out.println(fds.getMostFrequentlyAccessedNode());
        System.out.println(fds);

    }
}

class FastDataStructure {
    private final Map<ListNode, Integer> accessFrequencyMap = new HashMap<>();
    private final Map<Integer, ListNode> nodeMap = new HashMap<>();
    Stack<ListNode> mostFrequentNodes = new Stack<>();


    /**
     * adds to data structure
     */
    public void addListNode(ListNode node) {// O(1)
        this.mostFrequentNodes.push(node);
        this.nodeMap.put(node.val, node);
        this.accessFrequencyMap.put(node, 0);
    }

    /**
     * Finds node by value
     */
    public ListNode getNode(int nodeVal) {
        ListNode foundNode = this.nodeMap.get(nodeVal);
        if (foundNode == null) {
            System.err.println("Node not found");
            return null;
        }
        this.incrementAccessFrequency(foundNode);
        restructure();
        return foundNode;
    }

    /**
     * restructures based on access frequency
     * except for head element all elements are stored according to their internal frequency state
     * <p>
     * T.C => O(nlog(n))+O(n) ==> O(nlog(n))
     */
    private void restructure() {
        List<Map.Entry<ListNode, Integer>> sortedEntriesAsList = accessFrequencyMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        mostFrequentNodes.clear();
        sortedEntriesAsList.forEach(listNodeIntegerEntry -> {
            mostFrequentNodes.push(listNodeIntegerEntry.getKey());
        });
    }


    /**
     * gets the last added Node.
     */
    public ListNode getMostFrequentlyAccessedNode() { // O(1)
        return mostFrequentNodes.peek();
    }


    /**
     * Removes given node
     */
    public void removeNode(ListNode node) {
        if(accessFrequencyMap.get(node)==null){
            System.err.println("Data structure is empty");
            return;
        }
        this.accessFrequencyMap.remove(node);
        this.nodeMap.remove(node.val);
        if(node.val == mostFrequentNodes.peek().val){
            mostFrequentNodes.pop();
        }
    }


    public void incrementAccessFrequency(ListNode node) {
        Integer existingFrequency = this.accessFrequencyMap.getOrDefault(node, 0);
        this.accessFrequencyMap.put(node, existingFrequency + 1);
    }

    @Override
    public String toString() {
        return this.mostFrequentNodes.toString();
    }
}

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListNode{");
        sb.append("val=").append(val);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.val == ((ListNode) obj).val;
    }
}