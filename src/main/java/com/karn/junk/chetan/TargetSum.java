package com.karn.junk.chetan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;

public class TargetSum {

    public static void main(String[] args) {
        int length=100000;
        int[] arr=new int[length];
        for (int i = 0; i < length; i++) {
            int v = (int)(Math.random()*100);
            arr[i]=v;
        }
        int t= 1108013121;
        BiPredicate<int[],Integer> approach0 = (array,target)->{
            for (int i = 0; i < array.length; i++) {
                for (int j = i+1; j < array.length; j++) {
                    if(array[i]+array[j]==target){
                        return true;
                    }
                }
            }
            return false;
        };

        BiPredicate<int[],Integer> approach1 = (array,target)->{
            Arrays.sort(array);
            for (int i = 0,j=array.length-1; i < j ; ) {
                if(array[i]+array[j]<target){
                    i++;
                }else if(array[i]+array[j]>target){
                    j--;
                }else{
                    return true;
                }
            }
            return false;
        };
        BiPredicate<int[],Integer> approach2 = (array,target)->{
            Set<Integer> set=new HashSet<>();
            for (int i = array.length - 1; i >= 0; i--) {
                set.add(array[i]);
            }

            for (int i = 0; i < array.length; i++) {
                int find = target-array[i];
                if(set.contains(find)){//O(1)
                    return true;
                }
            }
            return false;
        };

        long startTime = System.currentTimeMillis();
        System.out.println(approach0.test(arr,t) );
        System.out.println(" took "+(System.currentTimeMillis()-startTime)+" ms");
         startTime = System.currentTimeMillis();
        System.out.println(approach1.test(arr,t) );
        System.out.println(" took "+(System.currentTimeMillis()-startTime)+" ms");
         startTime = System.currentTimeMillis();
        System.out.println(approach2.test(arr,t) );
        System.out.println(" took "+(System.currentTimeMillis()-startTime)+" ms");


    }

}
