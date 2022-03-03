package com.karn.leetcode;

import java.util.*;

public class TopKFrequentElementsUsingHeap {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        System.out.println(Arrays.toString(new TopKFrequentElementsUsingHeap()
                .topKFrequent(nums,2)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Structure> maxHeap = new PriorityQueue<>(k,Collections.reverseOrder());
        PriorityQueue<Structure> minHeap = new PriorityQueue<>();
        //map of key -> structure(key,value)
        Map<Integer,Structure> map=new HashMap<>();
        for (int num : nums) {
            Structure prev = map.getOrDefault(num, new Structure());
            prev.freq = 1 + prev.freq;
            if(prev.key!=Integer.MAX_VALUE){
                //KEY WAS PRESENT
                maxHeap.remove(prev);
                minHeap.remove(prev);
            }
            prev.key = num;
            map.put(num, prev);
            maxHeap.add(prev);
            minHeap.add(prev);

        }
        while(maxHeap.size()>k){
            //remove element with least frequency
            Structure remove = minHeap.remove();
            maxHeap.remove(remove);
        }

        int i=0;
        while(!maxHeap.isEmpty()){
            result[i] = maxHeap.poll().key;
            i++;
        }
        return result;
    }
    class Structure implements Comparable<Structure>{
        int key =Integer.MAX_VALUE;
        int freq;
        Structure(){

        }
        Structure(int key,int freq){
            this.key=key;
            this.freq=freq;
        }

        @Override
        public int compareTo(Structure o) {
            if(this.freq<=o.freq){
                return -1;
            }
            return 1;
        }
    }
}
