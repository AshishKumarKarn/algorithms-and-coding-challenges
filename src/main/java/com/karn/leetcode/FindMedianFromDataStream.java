package com.karn.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(2);
        medianFinder.addNum(10);
        medianFinder.addNum(12);//med
        medianFinder.addNum(21);//med
        medianFinder.addNum(12);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(8);

        System.out.println(medianFinder.findMedian());
    }
}


class MedianFinder {

    PriorityQueue<Integer> min;                             //minHeap
    PriorityQueue<Integer> max;                             //maxHeap

    public MedianFinder() {                                 //constructor
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()) {            //if num <= maxHeap's top element
            max.add(num);
        } else {
            min.add(num);
        }
        balanceHeap();                                      //self made fn. to balance it after each addition
    }

    public double findMedian() {
        if(max.size() == min.size()) {                      //even
            return ((double)max.peek() + min.peek()) / 2;
        } else {                                            //odd -> max.size() = min.size() + 1
            return max.peek();
        }
    }

    public void balanceHeap() {                             //self made fn. -> if it fails either 1) or 2) condition -> balance it
        if(max.size() > min.size() + 1) {                   //1) max = min + 1
            min.add(max.remove());
        } else if(min.size() > max.size()) {                //2) max = min
            max.add(min.remove());
        }
    }
}
