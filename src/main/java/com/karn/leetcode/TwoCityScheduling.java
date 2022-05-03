package com.karn.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs={{10,20},{30,200},{400,50},{30,20}};//110
       // int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        int output = new TwoCityScheduling().twoCitySchedCost(costs);
        System.out.println(output);
    }
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));
        int sum=0;
        for (int i = 0; i < costs.length; i++) {
            if(i<costs.length/2)
                sum+=costs[i][0];
            else
                sum+=costs[i][1];
        }
       return sum;
    }


}
