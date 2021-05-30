package com.karn.dsa;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversalOrBFSInBST {
    public static void main(String[] args) {
        BinarySearchTreeBFS binarySearchTreeBFS = new BinarySearchTreeBFS(11);
        binarySearchTreeBFS.add(12);
        binarySearchTreeBFS.add(13);
        binarySearchTreeBFS.add(10);
        binarySearchTreeBFS.add(1);
        binarySearchTreeBFS.add(3);
        binarySearchTreeBFS.add(14);
        binarySearchTreeBFS.printTree();
        binarySearchTreeBFS.levelOrderTraversal();
    }
}

class BinarySearchTreeBFS {
    NodeBFS rootNode;

    BinarySearchTreeBFS(int data) {
        this.rootNode = new NodeBFS(data);
    }

    public void add(int data) {
        add(data, rootNode);
    }

    public void printTree() {
        printTree(rootNode);
    }

    private void printTree(NodeBFS node) {
        if(node==null){
            System.out.println("Empty tree");
            return;
        }
        int nodeData = node.data;
        if (node.leftNode != null) {
            System.out.printf("%s Left Node >> %s \n", nodeData, node.leftNode.data);
            printTree(node.leftNode);
        }
        if (node.rightNode != null) {
            System.out.printf("%s Right Node >> %s \n", nodeData, node.rightNode.data);
            printTree(node.rightNode);
        }
    }

    private void add(int data, NodeBFS node) {
        if (data <= node.data) {
            if (node.leftNode != null) {
                add(data, node.leftNode);
            } else {
                node.leftNode = new NodeBFS(data);
            }
        } else {
            if (node.rightNode != null) {
                add(data, node.rightNode);
            } else {
                node.rightNode = new NodeBFS(data);
            }
        }
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(rootNode);
    }

    private Queue<NodeBFS> nodeBFSQueue = new ArrayDeque<>();

    private void levelOrderTraversal(NodeBFS node) {
        if (node == null) {
            return;
        }
        nodeBFSQueue.add(node);
        while (!nodeBFSQueue.isEmpty()) {
            NodeBFS current = nodeBFSQueue.peek();
            System.out.printf("Node>> %s \n", current.data);
            if(current.leftNode!=null){
                nodeBFSQueue.add(current.leftNode);
            }
            if(current.rightNode!=null){
                nodeBFSQueue.add(current.rightNode);
            }
            nodeBFSQueue.poll();
        }
    }

    private static class NodeBFS {
        private int data;
        private NodeBFS leftNode;
        private NodeBFS rightNode;

        NodeBFS(int data) {
            this.data = data;
        }

    }
}