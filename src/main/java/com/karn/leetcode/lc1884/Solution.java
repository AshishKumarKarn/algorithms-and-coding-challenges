package com.karn.leetcode.lc1884;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().twoEggDrop(1000));
    }
    public int twoEggDrop(int n) {
        int  i = n, count = 1, res = 0, result = 0;
        while(i>0) {
            res++;
            result = Math.max(result, res + count);
            i -= (count++);
        }
        return result/2;
    }

//    public int twoEggDrop(int n) {
//        int testFloor = n, count = 1;
//        int result = n;
//        while(testFloor>0){
//            int res = findMaxAttempts(n , testFloor);
//            result = Math.min(result, res);
//            testFloor = testFloor -1;
//        }
//        return result;
//    }
//    private int findMaxAttempts(int n, int testFloor){
//        int result = 0;
//        for(int ansFloor = 1; ansFloor <= n; ansFloor++){
//            if(testFloor==ansFloor){
//                result = Math.max(result, 1);
//                continue;
//            }
//            if (testFloor < ansFloor) {
//                int j = testFloor;
//                int res = 0;
//                while (j < ansFloor) {
//                    res++;
//                    j += testFloor;
//                }
//                result = res + (ansFloor - (j - testFloor + 1));
//            }
//            result = Math.max(result, 1 + ansFloor);
//        }
//        return result;
//    }
}
