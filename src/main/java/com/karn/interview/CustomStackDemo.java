package com.karn.interview;

import java.util.NoSuchElementException;

public class CustomStackDemo {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(5);
        stack.push(10);
        stack.push(12);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
class CustomStack{

    Node rootNode;
    Node pointer;
    CustomStack(){
    }
    void push(int val){
        if(this.rootNode == null){
            Node node = new Node();
            node.value =val;
            this.rootNode = node;
            this.pointer = node;
        }
        Node node = new Node();
        node.value = val;
        Node current = this.pointer;
        current.nextNode = node;
        node.prevNode = current;
        this.pointer = node;
    }
    int pop(){
        if(this.pointer!=null) {
            int val = this.pointer.value;
            Node prevNode = this.pointer.prevNode;
            this.pointer = prevNode;

            this.pointer.nextNode = null;
            return val;
        }else{
            throw new NoSuchElementException("Stack is empty");
        }
    }



    class Node{
        int value;
        Node nextNode;
        Node prevNode;
    }
}
