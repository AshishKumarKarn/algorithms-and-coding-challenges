package com.karn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(10));
    }
    public List<Integer> grayCode(int n) {
        List<String> sol =  greyCodeResolver(n);
        List<Integer> result = new ArrayList<>();
        for(String i:sol){
            result.add(Integer.parseInt(i,2));
        }
        return result;
    }
    private List<String> greyCodeResolver(int n){

        if(n==1){
            List<String> result = new ArrayList<>();
            result.add("0");
            result.add("1");
            return result;
        }
        List<String> result = greyCodeResolver(n-1);
        List<String> newResult = new ArrayList<>();
        for(int i=0;i<result.size();i++){
            newResult.add("0"+result.get(i));
        }
        for(int i=result.size()-1;i>=0;i--){
            newResult.add("1"+result.get(i));
        }
        return newResult;
    }

}
