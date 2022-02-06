package com.karn.dsa.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;

public class BinaryTreeTestBFS {
    public static void main(String[] args) {
        Node rootNode = new Node(null, null, 4);
        BinaryTree binaryTree = new BinaryTree(rootNode);
        binaryTree.addNode(new Node(2));
        binaryTree.addNode(new Node(1));
        binaryTree.addNode(new Node(3));
        binaryTree.addNode(new Node(8));
        binaryTree.addNode(new Node(5));
//        binaryTree.addNode(new Node(7));
        binaryTree.addNode(new Node(9));
        new BinaryTreeTestBFS().preOrder(rootNode);
        //1,
        System.out.println();
        new BinaryTreeTestBFS().postOrder(rootNode);
        System.out.println();
        new BinaryTreeTestBFS().inOrder(rootNode);
        System.out.println();
        new BinaryTreeTestBFS().levelOrderTraversal(rootNode);

    }


    void levelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        //Queue Content: 8 1 3
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            // queue 1 3
            if (head.left != null) {
                queue.add(head.left);
                //1 3 5
            }
            if (head.right != null) {
                queue.add(head.right);
                //8 1 3 9
            }
            System.out.printf("%s ,", head.data);
            //Output: 4 2
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            if (node.left != null)
                preOrder(node.left);
            if (node.right != null)
                preOrder(node.right);
            System.out.printf("%s ,", node.data);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            if (node.right != null)
                postOrder(node.right);
            if (node.left != null) {
                postOrder(node.left);
            }
            System.out.printf("%s ,", node.data);
        }
    }

    void inOrder(Node node) {
        if (node != null) {
            if (node.left != null)
                inOrder(node.left);
            System.out.printf("%s ,", node.data);
            if (node.right != null) {
                inOrder(node.right);
            }
        }
    }

}

class BinaryTree {
    Node rootNode;

    BinaryTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    //
    //
    //
    public void addNode(Node node) {
        addNode(node, rootNode);
    }

    private void addNode(Node nodeToAdd, Node currentNode) {
        if (nodeToAdd.data < currentNode.data) {
            //add in left
            if (currentNode.left == null) {
                currentNode.left = nodeToAdd;
            } else {
                addNode(nodeToAdd, currentNode.left);
            }
        } else if (nodeToAdd.data > currentNode.data) {
            //add in right
            if (currentNode.right == null) {
                currentNode.right = nodeToAdd;
            } else {
                addNode(nodeToAdd, currentNode.right);
            }
        }
    }

//    @Override
//    public String toString() {
//       StringBuilder sb=new StringBuilder();
//       Node node=this.rootNode;
//       while(node!)
//    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(Node left, Node right, int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node(int data) {
        this.data = data;
    }

}
