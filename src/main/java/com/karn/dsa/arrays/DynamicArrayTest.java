package com.karn.dsa.arrays;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>(2);
        dynamicArray.add("Ashish");
        dynamicArray.add("Aditya");
        dynamicArray.add("Amit");
        dynamicArray.add("Vivek");
        dynamicArray.add("Vinod");
        System.out.println(dynamicArray.getSize());
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.get(5));
    }

    private static class DynamicArray<T> {
        private int initialCapacity;
        private T[] data;
        private int size;

        DynamicArray(int initialCapacity) {
            if (initialCapacity <= 0) {
                throw new IllegalArgumentException("initial capacity should be greater than 0");
            }
            this.initialCapacity = initialCapacity;
            data = (T[]) new Object[initialCapacity];
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public T get(int index) {
            return data[index];
        }

        public boolean add(T data) {
            System.out.printf("Adding data %s %n", data);
            if (size == initialCapacity) {
                resize();
            }
            this.data[size] = data;
            size++;
            return true;
        }

        private void resize() {
            System.out.println("resize happened");
            int oldCapacity = initialCapacity;
            initialCapacity = oldCapacity * 2;
            Object[] oldData = this.data;
            this.data = (T[]) new Object[initialCapacity];
            for (int i = 0; i < oldCapacity; i++) {
                this.data[i] = (T) oldData[i];
            }

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < data.length; i++) {

                if (data[i] == null) {
                    int currentLength = sb.toString().length();
                    sb.replace(currentLength - 2, currentLength, "");
                    break;
                } else {
                    sb.append(data[i]);
                }
                sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
