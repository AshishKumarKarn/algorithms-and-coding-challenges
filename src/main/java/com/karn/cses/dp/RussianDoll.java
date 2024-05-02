package com.karn.cses.dp;

import java.util.*;
public class RussianDoll {
    public static void main(String[] args) {
        int[][] envelopes = {{4,5},{6,7},{2,3}};

        System.out.println(new RussianDoll().maxEnvelopes(envelopes));
    }
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0) return 0;
        List<int[]> intList = Arrays.stream(envelopes).toList();
        List<int[]> sortedList = intList.stream().sorted(Comparator.comparing(a -> a[0] + a[1])).toList();
        int[] lastEnvelope = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[][] dp =new int[envelopes.length+1][envelopes.length+1];

        return maxEnvelopes(sortedList, envelopes.length-1, lastEnvelope);
    }
    Map<String, Integer> memory = new HashMap<>();
    public int maxEnvelopes(List<int[]> envelopes, int cursor, int[] lastEnvelope) {
        String key = lastEnvelope[0]+" "+lastEnvelope[1];
        if(memory.containsKey(key)){
            return memory.get(key);
        }
        if(cursor==0){
            if(lastEnvelope[0]>envelopes.get(0)[0]&&lastEnvelope[1]>envelopes.get(0)[1]){
                return 1;
            }else {
                return 0;
            }
        }
        int result;
        if(lastEnvelope[0]>envelopes.get(cursor)[0]&&lastEnvelope[1]>envelopes.get(cursor)[1]){
            result = Math.max(1 + maxEnvelopes(envelopes, cursor - 1, envelopes.get(cursor)),
                    maxEnvelopes(envelopes, cursor - 1, lastEnvelope));
        }else{
            result = maxEnvelopes(envelopes, cursor - 1, lastEnvelope);
        }
        memory.put(key, result);
        return result;
    }
}
