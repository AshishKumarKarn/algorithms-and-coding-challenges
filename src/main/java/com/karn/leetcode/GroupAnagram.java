package com.karn.leetcode;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String s="bddd";
        System.out.println(new GroupAnagram().groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> strAna = new HashMap<>();

        for(String s:strs){
            String str =createKey(s);
            List<String> existing = null;
            if(strAna.containsKey(str)){
                existing = strAna.get(str);
            }else{
                existing = new ArrayList<>();
            }
            existing.add(s);
            strAna.put(str,existing);
        }
        for(Map.Entry<String,List<String>> entry:strAna.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
    private String createKey(String s){
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(arr[i]).append("_");
        }
        return sb.toString();
    }
}
