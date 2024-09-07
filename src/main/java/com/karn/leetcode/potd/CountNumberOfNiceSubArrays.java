package com.karn.leetcode.potd;

public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {
        CountNumberOfNiceSubArrays countNumberOfNiceSubArrays = new CountNumberOfNiceSubArrays();
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        System.out.println(countNumberOfNiceSubArrays.numberOfSubarrays(arr, k));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount=0;
        int subArrayCount=0;
        int moveCount=0;
        int i=0;int j=0;
        while(j<nums.length){
            while(j<nums.length&&oddCount<k){
                if(nums[j]%2!=0){
                    oddCount++;
                }
                if(oddCount==k){
                    break;
                }
                j++;
            }
            if(j==nums.length&&oddCount<k){
                break;
            }
            while(i<j){
                moveCount++;
                if(nums[i++]%2!=0){
                    break;
                }
            }
            while(j<nums.length){
                moveCount++;
                if(nums[j++]%2!=0){
                    break;
                }
            }
        }
        subArrayCount = moveCount *(moveCount-1)/2;
        return subArrayCount;
    }
}
