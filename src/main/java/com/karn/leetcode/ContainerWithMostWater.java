package com.karn.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result=0;
        for (int i = 0,j=height.length-1;i<j;) {
            result =Math.max(result,(j-i)* Math.min(height[i],height[j]));
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }
}
