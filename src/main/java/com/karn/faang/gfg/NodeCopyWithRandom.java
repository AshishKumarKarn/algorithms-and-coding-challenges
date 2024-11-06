package com.karn.faang.gfg;


import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class NodeCopyWithRandom {
    static class Node{
        Node next;
        int data;
        Node random;
        Node(int data){
            this.data=data;
        }

        public static String print(Node givenNode) {
            Node node = givenNode;
            StringBuilder sb = new StringBuilder();
            while(node !=null){
                sb.append(node.data).append(" ");
                node=node.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        node.random = node.next.next;
        node.next.next.random=node.next;

        Node node1 = copyList(node);
        System.out.println(Node.print(node1));
    }
    static Node copyList(Node head) {
        Map<Integer, Node> newNodes = new HashMap<>();
        // your code here
        Node node = head;
        Node newHead = new Node(node.data);
        newNodes.put(node.data, newHead);
        Node prevNewNode = new Node(-1);//dummyNode
        while(node!=null){
            Node n;
            if(!newNodes.containsKey(node.data)){
                n = new Node(node.data);
                newNodes.put(node.data, n);
            }else{
                n = newNodes.get(node.data);
            }
            Node rn = null;
            if(node.random!=null&&!newNodes.containsKey(node.random.data)){
                rn = new Node(node.random.data);
                newNodes.put(node.random.data, n);
            }else if(node.random!=null){
                rn = newNodes.get(node.random.data);
            }
            prevNewNode.next = n;
            prevNewNode.random = rn;
            prevNewNode = prevNewNode.next;
            node = node.next;
        }
        return newHead;
    }
}
