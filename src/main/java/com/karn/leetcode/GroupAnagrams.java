package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();

        if (strs.length == 0)
            return solution;
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (String str: strs) {
            String sorted=sorted(str);
            List<String> stringList = stringListMap.get(sorted);
            if(stringList==null){
                stringList=new ArrayList<>();
            }
            stringList.add(str);
            stringListMap.put(sorted, stringList);
        }
        solution = new ArrayList<>(stringListMap.values());
        return solution;
    }

    private String sorted(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
