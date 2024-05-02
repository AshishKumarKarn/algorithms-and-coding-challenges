package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(-1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(2); row2.add(3);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1); row3.add(-1); row3.add(-3);


        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        System.out.println(new Triangle().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> lastRow = triangle.get(triangle.size()-1);
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> currRow = triangle.get(i);
            for(int j=0;j<currRow.size();j++){
                int newValue= currRow.get(j)+Math.min(lastRow.get(j),lastRow.get(j+1));
                currRow.set(j, newValue);
            }
            lastRow = currRow;
        }
        return lastRow.get(0);
    }
}
