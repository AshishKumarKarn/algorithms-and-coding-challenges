package com.karn.algosolutions;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversalSolution {
    public static void main(String[] args) {
        Node rootNode = new Node(15);
        rootNode.left = new Node(13);
        rootNode.right = new Node(20);
        rootNode.left.left = new Node(12);
        rootNode.left.right = new Node(22);
        rootNode.right.left = new Node(18);
        rootNode.right.right = new Node(23);
        rootNode.left.left.left = new Node(8);
        rootNode.left.left.right = new Node(29);
        rootNode.left.right.right = new Node(33);

        //                15
        //             13    20
        //          12   22  18  23
        //         8  29    33

        // 15 13 20 12 22 18 23 8 29 33

        System.out.println(levelOrder(rootNode));
        //8 12 29 13 22 33 15 18 20 23
        System.out.println(inOrder(rootNode));
        //15 13 12 8 29 22 33 20 18 23
        System.out.println(preOrder(rootNode));
    }

    //Function to return the level order traversal of a tree.
    private static ArrayList<Integer> levelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        ArrayList<Integer> result = null;
        if (node != null) {
            result = new ArrayList<>();
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            result.add(head.data);
            if (head.left != null)
                queue.add(head.left);
            if (head.right != null)
                queue.add(head.right);
        }
        return result;
    }

    static ArrayList<Integer> result1 = new ArrayList<>();

    private static ArrayList<Integer> inOrder(Node root) {
        if (root != null) {
            if (root.left != null) {
                inOrder(root.left);
            }
            result1.add(root.data);
            if (root.right != null) {
                inOrder(root.right);
            }
        }
        return result1;
    }

    static ArrayList<Integer> result2 = new ArrayList<>();

    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preOrder(Node root) {
        if (root != null) {
            result2.add(root.data);
            preOrder(root.left);
            preOrder(root.right);

        }
        return result2;
    }

static class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }
}

static class Tree {
    Node rootNode;

    Tree(Node rootNode) {
        this.rootNode = rootNode;
    }
}
}
