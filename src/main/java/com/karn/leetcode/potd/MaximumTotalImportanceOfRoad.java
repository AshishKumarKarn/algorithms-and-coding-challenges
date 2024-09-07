package com.karn.leetcode.potd;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaximumTotalImportanceOfRoad {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer,Integer> nodeFreq = new HashMap<>();
        for(int[] road:roads){
            nodeFreq.put(road[0], nodeFreq.getOrDefault(road[0], 0)+1);
            nodeFreq.put(road[1], nodeFreq.getOrDefault(road[1], 0)+1);
        }
        List<Integer>[] graph = new List[n];

        Map<Integer,Integer> sorted =
                nodeFreq.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int result = 0;
        for(Map.Entry<Integer,Integer> entry:sorted.entrySet()){
            result += entry.getValue()*n;
            n--;
        }
        return result;
    }
    class Node implements Comparable<Node>{
        int val;
        int freq;
        Node(int val, int freq){
            this.val= val;
            this.freq = freq;
        }
        public int compareTo(Node n){
            return n.val-this.val;
        }
    }
}
