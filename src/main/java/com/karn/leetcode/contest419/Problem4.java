package com.karn.leetcode.contest419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/
public class Problem4 {
    public static void main(String[] args) {
        long[] xSum = new Problem4().findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2);
        System.out.println(Arrays.toString(xSum));
    }
    public long[] findXSum(int[] nums, int k, int x) {
        long[] results = new long[nums.length-k+1];
        int left=0;
        Map<Integer, Element> map = new HashMap<>();
        TreeSet<Element> maxHeap = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                Element e = map.get(nums[i]);
                maxHeap.remove(e);
                e.freq++;
                maxHeap.add(e);
            }else{
                Element e = new Element(nums[i], 1);
                maxHeap.add(e);
                map.put(nums[i], e);
            }
            if(i<k-1){
                continue;
            }else {//remove left cursor element and move left cursor to right by 1 element
                if(i!=k-1){
                    Element leftElement= map.get(nums[left-1]);
                    maxHeap.remove(leftElement);
                    leftElement.freq--;
                    maxHeap.add(leftElement);
                }


                long sum =0;
                List<Element> elements = new ArrayList<>();

                int t=x;
                while(t>0&&!maxHeap.isEmpty()&&maxHeap.first().freq>0){
                    Element element = maxHeap.pollFirst();
                    sum += (long) (element.freq) *(element.value);
                    t--;
                    elements.add(element);
                }
                maxHeap.addAll(elements);
                results[left++]=sum;//already incremented
            }
        }
        return results;
    }
    class Element implements Comparable<Element>{
        int value;
        int freq;

        Element(int value, int freq){
            this.value=value;
            this.freq=freq;
        }

        public int compareTo(Element that){
            if(this.freq==that.freq){
                return that.value-this.value;
            }
            return that.freq - this.freq;
        }
    }
}

