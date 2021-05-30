package com.karn.dsa;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraversalInBST {
    public static void main(String[] args) {
        BinarySearchTreeBFSDFS<Integer> binarySearchTreeBFSDFS = new BinarySearchTreeBFSDFS<>(11);
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

class BinarySearchTreeBFSDFS<T extends Comparable> {
    NodeBFS<T> rootNode;

    BinarySearchTreeBFSDFS(T data) {
        this.rootNode = new NodeBFS<>(data);
    }

    public void add(T data) {
        add(data, rootNode);
    }

    public void printTree() {
        printTree(rootNode);
    }

    private void printTree(NodeBFS<T> node) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }
        T nodeData = node.data;
        if (node.leftNode != null) {
            System.out.printf("%s Left Node >> %s \n", nodeData, node.leftNode.data);
            printTree(node.leftNode);
        }
        if (node.rightNode != null) {
            System.out.printf("%s Right Node >> %s \n", nodeData, node.rightNode.data);
            printTree(node.rightNode);
        }
    }

    private void add(T data, NodeBFS<T> node) {
//        Integer a=5;
//        Integer b=10;
//        System.out.println(a.compareTo(b)<=0);
//        => a <= b or here data <= node.data
        if (data.compareTo(node.data) <= 0) {
            if (node.leftNode != null) {
                add(data, node.leftNode);
            } else {
                node.leftNode = new NodeBFS<>(data);
            }
        } else {
            if (node.rightNode != null) {
                add(data, node.rightNode);
            } else {
                node.rightNode = new NodeBFS<>(data);
            }
        }
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(rootNode);
    }

    private final Queue<NodeBFS<T>> nodeBFSQueue = new ArrayDeque<>();

    private void levelOrderTraversal(NodeBFS<T> node) {
        if (node == null) {
            return;
        }
        nodeBFSQueue.add(node);
        while (!nodeBFSQueue.isEmpty()) {
            NodeBFS<T> current = nodeBFSQueue.peek();
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

    private void dfsPreOrder(NodeBFS<T> node) {
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

    private void dfsInOrder(NodeBFS<T> node) {
        if (node == null) return;
        if (node.leftNode != null) dfsInOrder(node.leftNode);
        System.out.printf("Node > %s \n", node.data);
        if (node.rightNode != null) dfsInOrder(node.rightNode);
    }

    public void dfsPostOrder() {
        dfsPostOrder(rootNode);
    }

    public void dfsPostOrder(NodeBFS<T> nodeBFS) {
        if (nodeBFS == null) return;
        if (nodeBFS.leftNode != null) dfsPostOrder(nodeBFS.leftNode);
        if (nodeBFS.rightNode != null) dfsPostOrder(nodeBFS.rightNode);
        System.out.printf("Node %s \n", nodeBFS.data);
    }

    private static class NodeBFS<Q extends Comparable> {
        private final Q data;
        private NodeBFS<Q> leftNode;
        private NodeBFS<Q> rightNode;

        NodeBFS(Q data) {
            this.data = data;
        }

    }
}