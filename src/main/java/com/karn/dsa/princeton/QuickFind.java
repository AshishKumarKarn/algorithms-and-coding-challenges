package com.karn.dsa.princeton;

import java.util.Arrays;

public class QuickFind {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(9);
        quickFind.union(5, 4);
        quickFind.union(2, 6);
        quickFind.union(7, 6);
        quickFind.union(3, 8);
        System.out.println(Arrays.toString(quickFind.ids));
        boolean sol1 = quickFind.connected(0, 6);
        System.out.println(sol1);//false
        boolean sol2 = quickFind.connected(2, 7);
        System.out.println(sol2);//true
    }
        private int[] ids;
    QuickFind(int n){
        ids=new int[n];
        for (int i = 0; i < ids.length; i++) {
            ids[i]=i;
        }
    }

    public boolean connected(int p,int q){
        return ids[p]==ids[q];
    }
    public void union(int p,int q){
        int pId = ids[p];
        int qId = ids[q];
        for (int i = 0; i < ids.length; i++) {
            if(ids[i]==pId) ids[i]=qId;
        }
    }
}
