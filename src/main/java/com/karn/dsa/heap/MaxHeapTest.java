package com.karn.dsa.heap;

public class MaxHeapTest {
    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insertElement(2);
        maxHeap.insertElement(3);
        maxHeap.insertElement(23);
        maxHeap.insertElement(4);
        maxHeap.insertElement(5);
        maxHeap.insertElement(21);
        maxHeap.insertElement(51);
        maxHeap.insertElement(22);
        maxHeap.insertElement(6);
        maxHeap.insertElement(8);
        maxHeap.insertElement(1);
        maxHeap.insertElement(26);
        System.out.println(maxHeap);

        maxHeap.deleteElement(1);

        System.out.println(maxHeap);


        MinHeap minHeap = new MinHeap();
        minHeap.insertElement(2);
        minHeap.insertElement(3);
        minHeap.insertElement(23);
        minHeap.insertElement(4);
        minHeap.insertElement(5);
        minHeap.insertElement(21);
        minHeap.insertElement(51);
        minHeap.insertElement(22);
        minHeap.insertElement(6);
        minHeap.insertElement(8);
        minHeap.insertElement(1);
        minHeap.insertElement(26);
        System.out.println(minHeap);

        minHeap.deleteElement(5);
        System.out.println(minHeap);

    }
}

class MaxHeap {
    private int[] elements;
    private int position;

    //set initial size array to 10;
    MaxHeap() {
        elements = new int[10];
        position = 0;
    }

    public void insertElement(int data) {
        if (position == elements.length) {
            int[] newArray = new int[2 * elements.length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[position] = data;
        int child = position;
        int parent = ((child + 1) / 2) - 1;
//        child/2;
        //max heap -> parent > child
        while (parent > -1 && elements[child] > elements[parent]) {
            int temp = elements[child];
            elements[child] = elements[parent];
            elements[parent] = temp;

            child = parent;
            parent = ((child + 1) / 2) - 1;
        }
        position++;
    }

    public void deleteElement(int index) {
        if (position == 0) {
            System.out.println("Please add element in heap to delete one");
            return;
        }
        if (index > position || index < 0) {
            System.out.printf("Please enter and valid index between %d and %d", 0, position);
            return;
        }

        int parentI= ((index+1)/2)-1;
        while (parentI>=0){
            int temp=elements[index];
            elements[index]=elements[parentI];
            elements[parentI]=temp;
            index = parentI;
            parentI= ((index+1)/2)-1;
        }
        elements[0] = elements[position - 1];

        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex <= position) {
            if (elements[leftChildIndex] > elements[parentIndex]
                    && elements[leftChildIndex] > elements[rightChildIndex]) {
                int element = elements[leftChildIndex];
                elements[leftChildIndex] = elements[parentIndex];
                elements[parentIndex] = element;
                parentIndex = leftChildIndex;
            } else if (elements[rightChildIndex] > elements[parentIndex]
                    && elements[rightChildIndex] > elements[leftChildIndex]) {
                int element = elements[rightChildIndex];
                elements[rightChildIndex] = elements[parentIndex];
                elements[parentIndex] = element;
                parentIndex = rightChildIndex;
            } else {
                break;
            }
            leftChildIndex = 2 * (parentIndex) + 1;
            rightChildIndex = 2 * (parentIndex) + 2;
        }
        position--;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < position; i++) {
            stringBuilder.append(elements[i]);
            if (i < position - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

class MinHeap {
    private int[] elements;
    private int position;

    //set initial size array to 10;
    MinHeap() {
        elements = new int[10];
        position = 0;
    }

    public void insertElement(int data) {
        if (position == elements.length) {
            int[] newArray = new int[2 * elements.length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[position] = data;
        int child = position;
        int parent = ((child + 1) / 2) - 1;
//        child/2;
        //max heap -> parent > child
        while (parent > -1 && elements[child] < elements[parent]) {
            int temp = elements[child];
            elements[child] = elements[parent];
            elements[parent] = temp;

            child = parent;
            parent = ((child + 1) / 2) - 1;
        }
        position++;
    }

    public void deleteElement(int index) {
        if (position == 0) {
            System.out.println("Please add element in heap to delete one");
            return;
        }
        if (index > position || index < 0) {
            System.out.printf("Please enter and valid index between %d and %d", 0, position);
            return;
        }

        int parentI= ((index+1)/2)-1;
        while (parentI>=0){
            int temp=elements[index];
            elements[index]=elements[parentI];
            elements[parentI]=temp;
            index = parentI;
            parentI= ((index+1)/2)-1;
        }
        elements[0] = elements[position - 1];

        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex <= position) {
            if (elements[leftChildIndex] < elements[parentIndex]
                    && (elements[leftChildIndex] < elements[rightChildIndex]||
                    rightChildIndex>position)) {
                int element = elements[leftChildIndex];
                elements[leftChildIndex] = elements[parentIndex];
                elements[parentIndex] = element;
                parentIndex = leftChildIndex;
            } else if (elements[rightChildIndex] < elements[parentIndex]
                    && elements[rightChildIndex] < elements[leftChildIndex]
            &&rightChildIndex<position) {
                int element = elements[rightChildIndex];
                elements[rightChildIndex] = elements[parentIndex];
                elements[parentIndex] = element;
                parentIndex = rightChildIndex;
            } else {
                break;
            }
            leftChildIndex = 2 * (parentIndex) + 1;
            rightChildIndex = 2 * (parentIndex) + 2;
        }
        position--;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < position; i++) {
            stringBuilder.append(elements[i]);
            if (i < position - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
