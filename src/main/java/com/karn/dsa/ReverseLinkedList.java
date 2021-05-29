package com.karn.dsa;

public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList(4);
        singlyLinkedList.addNode(5);
        singlyLinkedList.addNode(12);
        singlyLinkedList.addNode(52);
        singlyLinkedList.addNode(54);
        singlyLinkedList.addNode(3);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.insertNodeAtIndex(44, 6);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.reverseLinkedList();
        singlyLinkedList.printLinkedList();
        singlyLinkedList.addNode(32);
        singlyLinkedList.printLinkedList();

    }
}

class SinglyLinkedList<T> {
    private Node rootNode;
    private Node currentNode;

    SinglyLinkedList(T rootData) {
        this.rootNode = new Node(rootData);
        this.currentNode = rootNode;
    }

    void addNode(T data) {
        Node node = new Node(data);
        this.currentNode.nextNode = node;
        this.currentNode = node;
    }

    void reverseLinkedList() {
        Node cursor = rootNode;
        Node currentNode;
        Node lastNode = null;
        this.currentNode = rootNode;
        while (cursor != null) {
            currentNode = cursor;
            rootNode = currentNode;
            cursor = cursor.nextNode;
            currentNode.nextNode = lastNode;
            lastNode = currentNode;
        }
    }

    void printLinkedList() {
        Node cursor = this.rootNode;
        StringBuilder sb = new StringBuilder();
        while (cursor != null) {
            sb.append(cursor.data + " -> ");
            cursor = cursor.nextNode;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    void insertNodeAtIndex(int data, int index) {
        Node node = new Node(data);
        Node iteratingNode = this.rootNode;
        int iteratingIndex = 0;
        Node prevNode = null;
        boolean found = false;
        while (iteratingNode != null) {

            if (iteratingIndex == index) {
                node.nextNode = iteratingNode;
                if (prevNode != null) {
                    prevNode.nextNode = node;
                } else {
                    this.rootNode = node;
                }
                found = true;
                break;
            }
            iteratingIndex++;
            prevNode = iteratingNode;
            iteratingNode = iteratingNode.nextNode;
        }
        if (iteratingIndex == index) {
            found = true;
            prevNode.nextNode = node;
        }
        if (!found) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }

    private class Node<T> {
        private T data;
        private Node nextNode;

        Node(T data) {
            this.data = data;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public T getData() {
            return data;
        }
    }
}

