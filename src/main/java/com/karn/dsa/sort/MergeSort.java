package com.karn.dsa.sort;

public class MergeSort {
    int[] result;
    public void mergeSort(int[] array){
        result = new int[array.length];
        mergeSort(array, 0, array.length - 1);
    }
    private void mergeSort(int[] array, int i,int j){
        if(i<j){
            int mid = i + (j - i) / 2;
            mergeSort(array,i,mid);
            mergeSort(array,mid+1,j);
            sort(array,i,mid,j);
        }

    }
    public void sort(int[] arr,int i,int m,int j){
       int len1=m-i+1;
       int len2=j-m;
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];
        for (int k = 0; k < len1; k++) {
            arr1[k]=arr[i+k];
        }
        for (int k = 0; k < len2; k++) {
            arr2[k] = arr[m+1+k];
        }
        int k=i;
        int p=0,q=0;
        while(p<len1&&q<len2){
            if(arr1[p]<arr2[q]){
                arr[k++] = arr1[p++];
            }else {
                arr[k++] = arr2[q++];
            }
        }
        while(p<len1){
            arr[k++] = arr1[p++];
        }
        while(q<len2){
            arr[k++] = arr2[q++];
        }
    }

}
