package com.karn.algosolutions;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        String testCase = "Ashish";
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        
        for (int i = 0; i < testCase.length(); i++) {
            Integer prev = map.put(testCase.charAt(i),1);
            if(prev!=null){
                map.put(testCase.charAt(i),prev+1);
            }
        }
        Character c =null;
        for (Map.Entry<Character,Integer> entry: map.entrySet()) {
            if(entry.getValue()==1){
                c = entry.getKey();
                break;
            }
        }
        if(c!=null){
            System.out.println(testCase.indexOf(c));
        }

    }
}
