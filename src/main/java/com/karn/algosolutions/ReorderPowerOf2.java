package com.karn.algosolutions;

import java.util.HashMap;
import java.util.Map;

public class ReorderPowerOf2 {
    public static void main(String[] args) {
        System.out.println(new ReorderPowerOf2().reorderedPowerOf2(46));
    }
    private final Map<Integer,Boolean> memonize=new HashMap<>();
    public boolean reorderedPowerOf2(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        if(n%2!=0) return false;
        int[] numbers=new int[String.valueOf(n).length()];
        int i=0;
        while(n/10!=0){
            numbers[i]=n%10;
            n=n/10;
            i++;
        }
        numbers[i]=n%10;
        boolean result=false;
        for(int j=0;j<numbers.length;j++){
            for(int k=0;j!=k&&k<numbers.length;k++){
                int temp=numbers[j];
                numbers[j]=numbers[k];
                numbers[k]=temp;
                result |= reorderedPowerOf2(makeNumber(numbers));
            }
        }
        return result;
    }
    private int makeNumber(int[] numbers){
        int result=0;
        for(int i=numbers.length-1,j=0;i>=0;i--,j++){
            result+= numbers[i]*Math.pow(10,j);
        }
        return result;
    }
}
