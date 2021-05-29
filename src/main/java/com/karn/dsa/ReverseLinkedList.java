package com.karn.dsa;

public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList(4);
        singlyLinkedList.addNode("Ashish");
        singlyLinkedList.addNode("12");
        singlyLinkedList.addNode("52");
        singlyLinkedList.addNode("54");
        singlyLinkedList.addNode("3");
        singlyLinkedList.printLinkedList();
        singlyLinkedList.insertNodeAtIndex("14", 6);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.reverseLinkedList();
        singlyLinkedList.printLinkedList();
        singlyLinkedList.addNode("32");
        singlyLinkedList.printLinkedList();

    }
}

class SinglyLinkedList<T> {
    private Node<T> rootNode;
    private Node<T> currentNode;

    SinglyLinkedList(T rootData) {
        this.rootNode = new Node(rootData);
        this.currentNode = rootNode;
    }

    void addNode(T data) {
        Node<T> node = new Node(data);
        this.currentNode.nextNode = node;
        this.currentNode = node;
    }

    void reverseLinkedList() {
        Node<T> cursor = rootNode;
        Node<T> currentNode;
        Node<T> lastNode = null;
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
        Node<T> cursor = this.rootNode;
        StringBuilder sb = new StringBuilder();
        while (cursor != null) {
            sb.append(cursor.data).append(" -> ");
            cursor = cursor.nextNode;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    void insertNodeAtIndex(T data, int index) {
        Node<T> node = new Node<T>(data);
        Node<T> iteratingNode = this.rootNode;
        int iteratingIndex = 0;
        Node<T> prevNode = null;
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
            assert prevNode != null;
            prevNode.nextNode = node;
        }
        if (!found) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }

    private static class Node<Q> {
        private final Q data;
        private Node<Q> nextNode;

        Node(Q data) {
            this.data = data;
        }

    }
}

