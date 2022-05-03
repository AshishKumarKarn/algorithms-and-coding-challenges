package com.karn.dsa;

public class Stacks {
    public static void main(String[] args) {
        Stack stack=new Stack(3);
        stack.push(12);
        stack.push(11);
        System.out.println(stack);
        stack.push(55);
        stack.push(54);
        System.out.println(stack);
        System.out.println("popping "+stack.pop());
        System.out.println(stack);
        System.out.println("popping "+stack.pop());
        System.out.println(stack);
        System.out.println("popping "+stack.pop());
        System.out.println(stack);
        System.out.println("popping "+stack.pop());
        System.out.println(stack);
        System.out.println("popping "+stack.pop());
        System.out.println(stack);
        System.out.println("popping "+stack.pop());
        System.out.println(stack);
    }
}
class Stack{
    private int[] arr;
    private int cursor;
    private static final int DEFAULT_SIZE = 10;
    Stack(int size){
        arr = new int[size];
    }
    Stack(){
        arr=new int[DEFAULT_SIZE];
    }
    public void push(int element){
        if(cursor==this.arr.length){
            //resize
            System.out.println("Resizing");
            int newLength = this.arr.length << 1;
            System.out.println("old length is "+this.arr.length);
            System.out.println("new length is "+newLength);

            int[] newArr = new int[newLength];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[cursor]=element;
        System.out.println("Added element at index "+cursor);
        cursor++;
    }
    public int pop(){
        if(cursor==0){
            System.out.println("No element in stack");
            return -1;
        }
        cursor--;
        return arr[cursor];
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i = 0; i < cursor; i++) {
            sb.append(arr[i]);
            if(i!=cursor-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}