package com.karn.leetcode;

import java.util.Map;
/**unresolved*/
public class InterleavingStrings {
    public static void main(String[] args) {
        System.out.println(new InterleavingStrings().isInterleave("db",
                "b",
                "cbb"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaveCustom(s1,s2,s3);
    }
    private boolean isInterleaveCustom(String s1, String s2, String s3) {
        String[] s1a=s1.split("");
        String[] s2a=s2.split("");
        String[] s3a=s3.split("");
        return isInterleaveCustom(s1a,s2a,s3a,0,s1a.length,0,s2a.length,0,s3a.length);
    }

    private boolean isInterleaveCustom(String[] s1a,
                                       String[] s2a,
                                       String[] s3a,
                                       int i1, int j1,
                                       int i2, int j2,
                                       int i3, int j3){
        if((j3-i3)==0){
            return true;
        }
        if((j3-i3)!=(j2-i2)+(j1-i1)){
            return false;
        }
        boolean isS1Matching = isS1MatchingMax(s1a,s2a,s3a,i1,j1,i2,j2,i3,j3);
        if(isS1Matching){
            int i;
            int k=i3;
            int count=0;
            for(i=i1;i<j1;){
                if(!s1a[i].equals(s3a[k])){
                    break;
                }
                i++;
                k++;
                count++;
            }
            if(count==0){
                return false;
            }
            return isInterleaveCustom(s1a,s2a,s3a,i,s1a.length,i2,s2a.length,i+i3,s3a.length);
        }else{
            int i;
            int k=i3;
            int count=0;
            for(i=i2;i<j2;){
                if(!s2a[i].equals(s3a[k])){
                    break;
                }
                i++;
                k++;
                count++;
            }
            if(count==0){
                return false;
            }
            return isInterleaveCustom(s1a,s2a,s3a,i1,s1a.length,i,s2a.length,i+i3,s3a.length);
        }
    }

    private boolean isS1MatchingMax(String[] s1a,
                                    String[] s2a,
                                    String[] s3a,
                                    int i1, int j1,
                                    int i2, int j2,
                                    int i3, int j3){

        int countI;
        int i;
        int k=i3;
        for(countI=0,i=i1;i<j1;){
            if(!s1a[i].equals(s3a[k])){
                break;
            }
            i++;
            k++;
            countI++;
        }
        int j;
        int countJ;
        k=i3;
        for(countJ=0,j=i2;j<j2;){
            if(!s2a[j].equals(s3a[k])){
                break;
            }
            j++;
            k++;
            countJ++;
        }
        return countI>countJ;
    }
}
