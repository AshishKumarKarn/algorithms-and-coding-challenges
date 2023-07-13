package com.karn.techgig.potd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HandsOfStraight {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 6, 2, 3, 4, 7, 8};

        System.out.println(isStraightHand(9,3, arr));
    }
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        if(N%groupSize!=0){
            return false;
        }
        int totalChunks=N/groupSize;
Arrays.sort(hand);
        Map<Integer,Integer> freq = new LinkedHashMap<>();
        for(int i=0;i<N;i++){
            Integer existingCount = freq.getOrDefault(hand[i],0);
            freq.put(hand[i],existingCount+1);
        }
        int start=getStartElement(freq);
        if(freq.get(start)==0){
            freq.remove(start);
        }
        int currentElementLength = 1;

        int currentNumberOfChunks = 0;
        while(currentNumberOfChunks<totalChunks){
            while(currentElementLength<groupSize){
                if(!getNextKeysValueValid(freq,++start)){
                    return false;
                }
                currentElementLength++;
            }
            start = getStartElement(freq);
            if(start!=-1 && freq.get(start)!=null&&freq.get(start)==0){
                freq.remove(start);
            }
            currentElementLength = 1;
            currentNumberOfChunks++;
        }
        return freq.isEmpty();
    }
    private static boolean getNextKeysValueValid(Map<Integer,Integer> freq,Integer key){
        Integer existing =freq.get(key);
        if(existing!=null&&existing!=0){
            freq.put(key,existing-1);
            if(existing-1==0){
                freq.remove(key);
            }
            return true;
        }
        return false;
    }
    private static int getStartElement(Map<Integer,Integer> freq){
        for(Integer key:freq.keySet()){
            if(freq.get(key)>0 && (freq.get(key-1)==null||freq.get(key-1)==0)){
                //decrement the count of currentKey
                Integer existingFreq = freq.get(key);
                freq.put(key, existingFreq-1);
                return key;
            }
        }
        return -1;
    }
}
