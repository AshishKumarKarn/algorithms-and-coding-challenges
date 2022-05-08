package com.karn.faang;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //O(N)
    public int[] twoSum(int[] input, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i],i);
        }
        for (int i = 0; i < input.length; i++) {
            int remaining = target - input[i];
            Integer exists = map.get(remaining);
            if(exists!=null&&exists!=i){
                return new int[]{i,exists};
            }
        }
        return null;
    }
}
