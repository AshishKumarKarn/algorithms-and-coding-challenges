package com.karn.leetcode.leetcode75contest;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(new GroupAnagram().groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String key = getKey(strs[i]);
            System.out.println(key);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> li=new ArrayList<>();
                li.add(strs[i]);
                map.put(key, li);
            }
        }
        for(Map.Entry<String, List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
    private String getKey(String s) {
        long l = new Date().getTime() - 24*3600*1000;
        System.out.println(l);
        char[] sarr = s.toCharArray();
        int[] arr = new int[26];
        for(char c:sarr){
            arr[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i:arr){
            sb.append(i);
        }
        return sb.toString();
    }
}
