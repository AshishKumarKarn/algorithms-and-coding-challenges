package com.karn.dsa;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private final Map<Integer, Node> memory;
    private final ArrayDeque<Node> queue;
    private final int capacity;
    private int size;

    public LRUCache(int capacity) {
        queue = new ArrayDeque<>(capacity);
        memory = new HashMap<>(capacity + 1, 1);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (memory.get(key) == null) {
            return -1;
        }
        Node first = memory.get(key);
        queue.removeIf(n -> n.key == first.key);
        queue.addFirst(first);
        return first.value;
    }

    public void put(int key, int value) {
        if (size == capacity) {
            //remove tail or last element of queue
            Node node = queue.pollLast();
            if (node != null)
                memory.remove(node.key);
            size--;
        }

        Node node = new Node(key, value);
        queue.removeIf(n -> n.key == key);
        queue.addFirst(node);
        memory.put(key, node);
        size++;
    }

    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }
}

