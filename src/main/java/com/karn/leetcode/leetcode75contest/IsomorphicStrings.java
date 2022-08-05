package com.karn.leetcode.leetcode75contest;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Map<Character,Character> memory1 = new HashMap<>();
        Map<Character,Character> memory2 = new HashMap<>();
        for (int i = 0; i < charsS.length; i++) {
            if(memory1.containsKey(charsS[i])){
                Character val = memory1.get(charsS[i]);
                if(val!=charsT[i]){
                    return false;
                }
            }else{
                memory1.put(charsS[i],charsT[i]);
            }
            if(memory2.containsKey(charsT[i])){
                Character val = memory2.get(charsT[i]);
                if(val!=charsS[i]){
                    return false;
                }
            }else{
                memory2.put(charsT[i],charsS[i]);
            }
        }
        return true;
    }
}
