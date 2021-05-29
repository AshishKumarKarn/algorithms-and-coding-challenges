package com.karn.dsa;

public class BinarySearchTreeOperations {
    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(15);
        binarySearchTree.addNode(14);
        binarySearchTree.addNode(16);
        binarySearchTree.addNode(19);
        binarySearchTree.addNode(18);
        binarySearchTree.addNode(5);
        binarySearchTree.printTree();
        System.out.println(binarySearchTree.searchNode(19));

    }
}

class BinarySearchTree {
    private Node rootNode;

    BinarySearchTree(int data) {
        this.rootNode = new Node(data);
    }

    public void printTree(){
        printTreeNode(rootNode);
    }
    private void printTreeNode(Node node){
        if(node==null){
            System.out.println("End reached");
            return;
        }
        if(node.leftNode!=null){
            System.out.println(node.data+">> left >>"+node.leftNode.data);
            printTreeNode(node.leftNode);
        }
        if(node.rightNode!=null){
            System.out.println(node.data+">> right >>"+node.rightNode.data);
            printTreeNode(node.rightNode);
        }
    }
    public boolean searchNode(int data){
        return searchNode(data, rootNode);
    }
    private boolean searchNode(int data, Node node) {
        if(data==node.data){
            System.out.printf("ELEMENT FOUND WITH DATA %s ", data);
            System.out.println();
            return true;
        }
        if (data <= node.data) {
            if (node.leftNode != null) {
                return searchNode(data, node.leftNode);
            } else {
                return false;
            }
        } else {
            if (node.rightNode != null) {
                return searchNode(data, node.rightNode);
            } else {
                return false;
            }
        }
    }

    public void addNode(int data) {
        addNode(data, rootNode);
    }

    private void addNode(int data, Node node) {
        if (data <= node.data) {
            if (node.leftNode != null) {
                addNode(data, node.leftNode);
            } else {
                node.leftNode = new Node(data);
            }
        } else {
            if (node.rightNode != null) {
                addNode(data, node.rightNode);
            } else {
                node.rightNode = new Node(data);
            }
        }
    }

    private class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;

        Node(int data) {
            this.data = data;
        }
    }
}