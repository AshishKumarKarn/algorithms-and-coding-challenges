package com.karn.leetcode.leetcode75contest;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max=Integer.MAX_VALUE;
        int[] leftMin = new int[prices.length];
        int[] rightMax = new int[prices.length];
        int min=-1;
        for(int i=0,j=prices.length-1;i<prices.length;i++,j--){
            if(prices[i]<max){
                max=prices[i];
            }
            if(prices[j]>min){
                min=prices[j];
            }
            leftMin[i]=max;
            rightMax[j] = min;
        }
        int result=0;
        for(int i=0;i<prices.length;i++){
            if(leftMin[i]<rightMax[i] && result<(rightMax[i]-leftMin[i])){
                result = rightMax[i]-leftMin[i];
            }
        }
        return result;
    }
}
