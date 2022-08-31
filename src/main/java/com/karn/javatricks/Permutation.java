package com.karn.javatricks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        Set<String> result = new HashSet<>();
        permutation(str.toCharArray(),0, result);
        System.out.println(result);
    }

    private static void permutation(char[] str,int index, Set<String> strs) {
        if(index>= str.length){
            strs.add(new String(str));
            return;
        }
        strs.add(new String(str));
        for (int i = index; i < str.length; i++) {
            swap(index,i,str);
            permutation(str,index+1,strs);
            //backtracking
            swap(index,i,str);
        }

    }

    private static void swap(int i, int r, char[] str) {
        char temp = str[i];
        str[i]= str[r];
        str[r]=temp;
    }
}
