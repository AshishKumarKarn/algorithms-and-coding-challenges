package com.karn.javatricks;

import java.util.HashSet;

public class AllPermutationOfString {

    public static void main(String[] args) {
        String str = "ABC";
        HashSet<String> result = new HashSet<>();
        permute(str.toCharArray(),0,result);
        System.out.println(result);
    }

    private static void permute(char[] toCharArray, int index, HashSet<String> result) {
        if(index>=toCharArray.length){
            result.add(new String(toCharArray));
        }
        for (int i = index; i < toCharArray.length; i++) {
            swap(i,index,toCharArray);
            permute(toCharArray,index+1,result);
            swap(i,index,toCharArray);
        }
    }

    private static void swap(int i, int index, char[] toCharArray) {
        char temp=toCharArray[index];
        toCharArray[index]=toCharArray[i];
        toCharArray[i]=temp;
    }
}
