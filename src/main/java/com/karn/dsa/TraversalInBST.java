package com.karn.dsa;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraversalInBST {
    public static void main(String[] args) {
        BinarySearchTreeBFSDFS binarySearchTreeBFSDFS = new BinarySearchTreeBFSDFS(11);
        binarySearchTreeBFSDFS.add(12);
        binarySearchTreeBFSDFS.add(13);
        binarySearchTreeBFSDFS.add(10);
        binarySearchTreeBFSDFS.add(1);
        binarySearchTreeBFSDFS.add(3);
        binarySearchTreeBFSDFS.add(14);
        binarySearchTreeBFSDFS.printTree();
        binarySearchTreeBFSDFS.levelOrderTraversal();
        System.out.println("DFS preOrder>> **print** **left** **right**");
        binarySearchTreeBFSDFS.dfsPreOrder();
        System.out.println("DFS inOrder>> **left** **print** **right** \nIn order prints data in sorted order");
        binarySearchTreeBFSDFS.dfsInOrder();
        System.out.println("DFS postOrder>> **left** **right** **print**");
        binarySearchTreeBFSDFS.dfsPostOrder();
    }
}

class BinarySearchTreeBFSDFS {
    NodeBFS rootNode;

    BinarySearchTreeBFSDFS(int data) {
        this.rootNode = new NodeBFS(data);
    }

    public void add(int data) {
        add(data, rootNode);
    }

    public void printTree() {
        printTree(rootNode);
    }

    private void printTree(NodeBFS node) {
        if (node == null) {
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
            if (current.leftNode != null) {
                nodeBFSQueue.add(current.leftNode);
            }
            if (current.rightNode != null) {
                nodeBFSQueue.add(current.rightNode);
            }
            nodeBFSQueue.poll();
        }
    }

    public void dfsPreOrder() {
        dfsPreOrder(rootNode);
    }

    private void dfsPreOrder(NodeBFS node) {
        if (node == null) {
            return;
        }
        System.out.println("Node >" + node.data);
        if (node.leftNode != null) {
            dfsPreOrder(node.leftNode);
        }
        if (node.rightNode != null) {
            dfsPreOrder(node.rightNode);
        }
    }

    public void dfsInOrder() {
        dfsInOrder(rootNode);
    }

    private void dfsInOrder(NodeBFS node) {
        if (node == null) return;
        if (node.leftNode != null) dfsInOrder(node.leftNode);
        System.out.printf("Node > %s \n", node.data);
        if (node.rightNode != null) dfsInOrder(node.rightNode);
    }

    public void dfsPostOrder() {
        dfsPostOrder(rootNode);
    }

    public void dfsPostOrder(NodeBFS nodeBFS) {
        if (nodeBFS == null) return;
        if (nodeBFS.leftNode != null) dfsPostOrder(nodeBFS.leftNode);
        if (nodeBFS.rightNode != null) dfsPostOrder(nodeBFS.rightNode);
        System.out.printf("Node %s \n", nodeBFS.data);
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