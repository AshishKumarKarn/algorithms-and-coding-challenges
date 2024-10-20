package com.karn.facebook.hackercup;

import java.util.*;

/**
 * @link https://www.facebook.com/codingcompetitions/hacker-cup/2024/practice-round/problems/A
 * */
public class Solution1{

    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            double testCases = sc.nextDouble();
            int t=1;
            while(testCases>0){
                int players = sc.nextInt();
                double time = sc.nextDouble();

                double[] arr=new double[players];
                for(int i=0;i<arr.length;i++){
                    arr[i]=sc.nextDouble();
                }
                if(solve(time, players, arr)){
                    System.out.println("Case #"+(t++)+": YES");

                }else{
                    System.out.println("Case #"+(t++)+": NO");
                }
                testCases--;
            }
        }
    }
    private static boolean solve(double time, int n, double[] travelTimes){

        Arrays.sort(travelTimes);
        if(n==1) return time>=travelTimes[0];
        double timeTaken = 0;

        for(double i=n-1;i>=1;i--){

            if(i==1){ timeTaken += travelTimes[0];}else{
                timeTaken += 2*travelTimes[0];}

        }

        return time>= timeTaken;
    }
}
