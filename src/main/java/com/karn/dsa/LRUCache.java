package com.karn.dsa;

import java.util.HashMap;
import java.util.Map;

public class LRUCache{
    public static void main(String[] args) {
        LRUCacheImpl lruCache = new LRUCacheImpl(4);
        lruCache.put(1,2);
        System.out.println(lruCache);
        lruCache.put(3,4);
        System.out.println(lruCache);
        lruCache.put(2,9);
        System.out.println(lruCache);
        lruCache.put(1,5);
        System.out.println(lruCache);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache);
        lruCache.put(1,6);
        System.out.println(lruCache);
        lruCache.put(5,9);
        System.out.println(lruCache);
        lruCache.put(6,19);
        System.out.println(lruCache);
    }
}
class LRUCacheImpl {

    private final Map<Integer, Node> memory;
    private final LinkedList<Node> queue;
    private final int capacity;

    public LRUCacheImpl(int capacity) {
        queue = new LinkedList<>(capacity);
        memory = new HashMap<>(capacity + 1, 1);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = memory.get(key);
        queue.remove(node);
        queue.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = memory.get(key);
        if (node != null) {
            //key was already present, so it's an update operation
            //no need to evict and size is not changing
            queue.remove(node);
            Node insert = new Node(key, value);
            queue.addFirst(insert);
            memory.put(key, insert);
            return;
        } else if (memory.size() == capacity) {
            //evict
            Node lastNode = queue.lastNode;
            queue.remove(lastNode);
            memory.remove(lastNode.key);
        }
        Node insert = new Node(key, value);
        queue.addFirst(insert);
        memory.put(key, insert);
    }

    @Override
    public String toString() {
        return "LRUCacheImpl{" +
                "queue=" + queue +
                '}';
    }

    static class LinkedList<N extends Node> {
        N rootNode;
        N lastNode;
        int size;

        LinkedList(int size) {
            this.size = size;
        }

        public void remove(N n) {
            N prevNode = (N) n.prevNode;
            N nextNode = (N) n.nextNode;
            if (prevNode != null) {
                prevNode.nextNode = nextNode;
            } else {
                rootNode = nextNode;
            }
            if (nextNode != null) {
                nextNode.prevNode = prevNode;
            } else {
                lastNode = prevNode;
            }
        }

        public void addFirst(N n) {
            if(rootNode==null){
                this.rootNode = n;
                return;
            }
            rootNode.prevNode = n;
            n.nextNode = rootNode;
            rootNode = n;
        }

        @Override
        public String toString() {
            if(rootNode==null){
                return "";
            }
            StringBuilder sb=new StringBuilder();
            N node = this.rootNode;
            sb.append("[");
            while(node.nextNode!=null){
                sb.append(node.key).append("=").append(node.value).append(",");
                node= (N) node.nextNode;
            }
            sb.append(node.key).append("=").append(node.value).append("]");
            return sb.toString();
        }
    }

    static class Node {
        int key;
        int value;
        Node prevNode;
        Node nextNode;

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

