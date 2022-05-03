package com.karn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand={1,2,3,4,5};
        int groupSize=4;
        System.out.println(new HandOfStraights().isNStraightHand(hand,groupSize));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> memory = new HashMap<>();
        for (int k : hand) {
            Integer existing = memory.getOrDefault(k, 0);
            memory.put(k, ++existing);
        }
        for (int j : hand) {
            if (!memory.containsKey(j - 1)||memory.get(j-1)==0) {
                //beginning of a group
                int increment = 0;
                while (increment < groupSize) {
                    if (!memory.containsKey(j + increment)) {
                        return false;
                    }else{
                        int existing = memory.getOrDefault(j + increment, 0);
                        if(existing==0){
                            return false;
                        }
                        memory.put(j+increment,--existing);
                    }
                    increment++;
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry:memory.entrySet()){
            if(entry.getValue()>0){
                return false;
            }
        }
        return true;
    }
}
