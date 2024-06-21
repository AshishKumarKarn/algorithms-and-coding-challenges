package com.karn.leetcode.potd;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        int sum=0;
        for(int c:customers){
            sum += c;
        }
        if(minutes>=n){
            return sum;
        }
        int windowSum=0;
        for(int i=0;i<minutes;i++){
            windowSum += customers[i];
        }
        int currSum = 0;
        int[] suffSum = new int[n+1];
        for(int i=n-1;i>=0;i--){
            if(grumpy[i]==0){
                currSum += customers[i];
            }
            suffSum[i] = currSum;
        }

        int maxSum = windowSum + suffSum[minutes];
        for(int i=1,j=minutes;i<=n-minutes;i++,j++){
            if(grumpy[i]==0){
                currSum += customers[i];
            }
            windowSum -= customers[i-1];
            windowSum += customers[j];
            maxSum = Math.max(maxSum, (windowSum + suffSum[j+1] + currSum));
        }

        return maxSum;
    }
}
