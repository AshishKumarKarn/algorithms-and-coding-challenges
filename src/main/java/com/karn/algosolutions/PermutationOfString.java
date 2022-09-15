package com.karn.algosolutions;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {
    public static void main(String[] args) {
        String str="ABC";
        Set<String> result=new HashSet<>();
        permute(str.toCharArray(),0,result);
        System.out.println(result);
    }

    private static void permute(char[] toCharArray, int index, Set<String> result) {
        if(index>=toCharArray.length){
            result.add(new String(toCharArray));
        }
        for (int i = index; i < toCharArray.length; i++) {
            swap(i,index,toCharArray);
            permute(toCharArray,index+1,result);
            //BACKTRACKING
            swap(i,index,toCharArray);
        }
    }

    private static void swap(int i, int index, char[] toCharArray) {
        char temp=toCharArray[i];
        toCharArray[i]=toCharArray[index];
        toCharArray[index]=temp;
    }
}
