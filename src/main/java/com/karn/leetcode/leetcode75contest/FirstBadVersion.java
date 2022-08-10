package com.karn.leetcode.leetcode75contest;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstBadVersion {

    //API DEFINED IN SOME PARENT CLASS
    private boolean isBadVersion(int n){
        return false;
    }
    public int firstBadVersion(int n) {
        //range 1 -> n
        if(isBadVersion(1)){
            return 1;
        }

        return getBadVersion(1,n);
    }
    private int getBadVersion(int start,int end){
        int mid =start +((end-start)/2);
        boolean res = isBadVersion(mid);
        if(res&&!isBadVersion(mid-1)){
            return mid;
        }else if(res){
            return getBadVersion(start,mid-1);
        }else{
            return getBadVersion(mid+1,end);
        }
    }

}
