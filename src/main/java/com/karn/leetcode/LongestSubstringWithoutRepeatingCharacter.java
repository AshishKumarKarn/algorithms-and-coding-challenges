package com.karn.leetcode;

import java.util.HashMap;
import java.util.Map;
//another approach
public class LongestSubstringWithoutRepeatingCharacter {
//    "rrrfsfsfdfdfkbfjvsdfjajODAWJFSNNSDSVSNCDADASDDDDASSS"
public static void main(String[] args) {
    System.out.println(new LongestSubstringWithoutRepeatingCharacter()
            .lengthOfLongestSubstring("rrrfsfsfdfdfkbfjvsdfjajODAWJFSNNSDSVSNCDADASDDDDASSS"));
}
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2){
            return s.length();
        }
        Map<Character,Integer> map=new HashMap<>(s.length(),1);
        int count=1;
        map.put(s.charAt(0),0);
        for(int i=0,j = 1; j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                int temp=i;
                i=map.get(s.charAt(j))+1;
                for (int k = temp; k < i; k++) {
                    map.remove(s.charAt(k));
                }
            }
            map.put(s.charAt(j),j);
            if((j-i+1)>count){
                count=j-i+1;
            }
        }
        return count;
    }
}
