package com.karn.dsa.tree;

public class BSTDemo {
    public static void main(String[] args) {
        BST bst=new BST();
        bst.addNode(8);
        bst.addNode(6);
        bst.addNode(2);
        bst.addNode(3);
        bst.addNode(12);
        bst.addNode(9);
        bst.addNode(1);
        bst.addNode(7);
        bst.addNode(5);

    }
    static class BST{
        Node root;

        void addNode(int value){
            if(this.root==null){
                this.root = new Node(value);
            }else{
                addNode(this.root, value);
            }
        }
        private Node addNode(Node node, int value){
            if(node==null){
                return new Node(value);
            }
            if(node.value>value){
                node.leftNode = addNode(node.leftNode, value);
            }else{
                node.rightNode = addNode(node.rightNode, value);
            }
            return node;
        }

        class Node{
            Node(int value){
                this.value = value;
            }
            int value;
            Node leftNode;
            Node rightNode;
        }
    }

}
