package com.karn.leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(heights));
    }

    public int trap(int[] height) {
        //if heighti > mids && heightsj > mids
        int totalTrappedWaterVolume = 0;

        for(int i=0,j=height.length-1;i<j;){
            int buildingVolume=getBuildingVolume(height,i,j,Math.min(height[i],height[j]));
            int current = (j-i-1)*Math.min(height[j],height[i])-(buildingVolume);
            if(current>0){
                totalTrappedWaterVolume += current;
            }
            if(!midBuildings){
                break;
            }
            if(height[j]>height[i]){
                i++;
            }else{
                j--;
            }
        }
        return totalTrappedWaterVolume;
    }
    boolean midBuildings=false;

    private int getBuildingVolume(int[] height, int i, int j, int min) {
        int vol=0;
        boolean mid=false;
        for (int k = i+1; k < j; k++) {
            if(height[k]>=min){
                vol+=min;
                mid = true;
            }else{
                vol+=height[k];
            }
        }
        if(mid){
            midBuildings =true;
        }else{
            midBuildings =false;
        }

        return vol;
    }
}
