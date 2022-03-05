package com.karn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, null);
    }
    Map<Integer,Node> memory = new HashMap<>();
    private Node cloneGraph(Node node, Node newNode){
        if(node==null){
            return null;
        }
        if(memory.containsKey(node.val)){
            return memory.get(node.val);
        }
        newNode = new Node(node.val);
        memory.put(node.val, newNode);
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node ne = node.neighbors.get(i);
            newNode.neighbors.add(cloneGraph(ne,null));
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
