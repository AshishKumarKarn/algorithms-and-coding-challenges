package com.karn.leetcode.lc3356;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,0,2};
        int[][] queries = new int[][]{{0,2,1},{0,2,1},{1,1,3}};
        System.out.println(new Solution().minZeroArray(nums, queries));
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int count = 0;
        int[] arr = new int[nums.length+1];
        if(isZeroArray(nums, arr)){
            return count;
        }
        int k =queries.length;
        int left = 0;
        int right = k;
        int result = k+1;
        while(left<=right){
            int mid = (right+left)/2 ;
            arr = new int[nums.length+1];
            applyQuery(arr,queries,mid);
            if(isZeroArray(nums, arr)){
                result = Math.min(result, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return result==k+1?-1:result;
    }
    private void applyQuery(int[] arr, int[][] queries, int k){
        for(int i=0;i<k;i++){
            int[] query = queries[i];
            arr[query[0]] -= query[2];
            arr[query[1]+1] += query[2];
        }
    }
    private boolean isZeroArray(int[] nums, int[] arr){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += arr[i];
            if(nums[i]+sum>0){
                return false;
            }
        }
        return true;
    }
}
