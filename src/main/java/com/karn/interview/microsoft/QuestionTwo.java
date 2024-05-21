package com.karn.interview.microsoft;

import java.util.*;

public class QuestionTwo {
    //[2, 4, 1, 3, 4, 6]
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 4, 6};
        QuestionTwo questionTwo = new QuestionTwo();
        System.out.println(questionTwo.solution(arr));
        System.out.println(questionTwo.working(arr));
        System.out.println(questionTwo.usingDp(arr));
    }
    public int solution(int[] arr){
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i=i+2) {
            pairs.add(new Pair(arr[i],arr[i+1]));
        }
        int maxPairs = 1;
        for (int i = 0; i < pairs.size(); i++) {
            int pairCount=1;
            int right = pairs.get(i).right;
            for (int j = i+1; j < pairs.size(); j++) {
                Pair pair = pairs.get(j);
                if(right == pair.left){
                    pairCount++;
                }
                right = pair.right;
            }
            maxPairs = Math.max(pairCount, maxPairs);
        }
        return pairs.size() - maxPairs;
    }
    class Pair{
        int left;
        int right;
        Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public int working(int[] arr){
        Map<Integer, Integer> seqMap = new HashMap<>();
        int seqMax = 0;
        for(int i=0;i < arr.length;i = i + 2) {
            int left = arr[i];
            int right = arr[i + 1];
            if(seqMap.containsKey(left)) { // Already a sequence ending with left value, then add one to the seq and key as right
                int prev = seqMap.get(left);
                seqMap.put(right, prev + 1);
            }
            if(!seqMap.containsKey(right)) // New seq start. key as right always so that next domino can look for the ending sequence
                seqMap.put(right, 1);
            seqMax = Math.max(seqMax, seqMap.get(right));
        }
        return ((arr.length/2) - seqMax);
    }

    public int usingDp(int[] arr){
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i=i+2) {
            pairs.add(new Pair(arr[i],arr[i+1]));
        }
        dp = new int[pairs.size()+1];
        Arrays.fill(dp, -1);
        int max = usingDp(pairs,pairs.get(pairs.size()-1).right, pairs.size());

        return pairs.size()-max;
    }

    int[] dp;
    private int usingDp(List<Pair> pairs,int lastLeftValue,  int cursor) {
        if(cursor==0){
            return 0;
        }
        if(dp[cursor]!=-1){
            return dp[cursor];
        }
        if(pairs.get(cursor-1).right==lastLeftValue){
            return dp[cursor]=Math.max(1+usingDp(pairs,pairs.get(cursor-1).left,cursor-1 ),usingDp(pairs,lastLeftValue,cursor-1));
        }else{
            return dp[cursor]=usingDp(pairs, lastLeftValue, cursor-1);
        }
    }
}
