package com.karn.interview.smarsh.round2;

//given parking entries
//trips = [[2,1,5],[3,3,7]] capacity=4
//find if these intervals can accommodate the capacity when it overlaps.
// for first entry, 2 , 1 ,5
//2 denotes number of person going from point 1 to point 5
//in this case the intervals are overlapping and on point 3 to 5 the volume is 2+3
//that is more the 4 the capacity, so it should return false for the given example.
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().
                        canTransit(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));//false
    }
    public boolean canTransit(int[][] trips, int capacity){
        int[] line = new int[101];
        for(int[] trip: trips){
            int start = trip[1];
            int end = trip[2];
            line[start]+= trip[0];
            line[end+1]-=trip[0];
        }
        int size = 0;
        for(int i=0;i<101;i++){
            size += line[i];
            if(size>capacity){
                return false;
            }
        }
        return true;
    }
}
