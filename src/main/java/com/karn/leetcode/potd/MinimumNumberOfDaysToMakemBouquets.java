package com.karn.leetcode.potd;


//Leetcode 1482
public class MinimumNumberOfDaysToMakemBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int target=(m*k);
        if(target>bloomDay.length) return -1;
        int min=Integer.MAX_VALUE;
        int max=0;

        for(int i:bloomDay){
            min=Math.min(min, i);
            max=Math.max(max, i);
        }
        int sol=binarySearch(min, max, bloomDay, m, k);
        return sol==Integer.MAX_VALUE?-1:sol;
    }
    private int binarySearch(int left, int right, int[] bloomDay, int m, int k){
        if(left>right){
            return Integer.MAX_VALUE;
        }
        int mid = left +(right-left)/2;
        int conCount=0;
        int mb=m;
        boolean found=false;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                conCount++;
            }else{
                conCount=0;
            }
            if(conCount==k){
                mb--;
                conCount=0;
            }
            if(mb==0){
                found =true;
                break;
            }
        }
        if(found){
            return Math.min(mid, binarySearch(left, mid-1, bloomDay, m, k));
        }else{
            return binarySearch(mid+1, right, bloomDay, m, k);
        }
    }
}
