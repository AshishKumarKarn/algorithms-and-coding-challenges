package com.karn.leetcode;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> memory = new HashMap<>();
        Set<Map.Entry<Integer,Integer>> queue = new TreeSet<>((a,b)->a.getValue()>=b.getValue()?-1:1);
        for (int num : nums) {
            Integer value = memory.getOrDefault(num, 0);
            memory.put(num,value+1);
        }

        queue.addAll(memory.entrySet());
        // System.out.println(queue);
        int i=0;
        for (Map.Entry<Integer,Integer> entry:queue) {
            if(k==0){
                break;
            }
            result[i] = entry.getKey();
            i++;
            k--;
        }
        return result;
    }
}
