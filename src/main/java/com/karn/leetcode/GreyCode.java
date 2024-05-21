package com.karn.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GreyCode {
    public static void main(String[] args) {
        System.out.println(1<<2);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        return grayCodeSolver(n, result, false);
    }
    Set<Integer> memory = new HashSet<>();

    private List<Integer> grayCodeSolver(int n, List<Integer> result, boolean allVisited) {
        if(allVisited){
            return result;
        }

return null;
    }
}
