package com.karn.algotricks;

public class SegmentTree{
    int[] arr;
    int[] segmentTree;
    SegmentTree(int[] arr){
        this.arr = arr;
        this.segmentTree = new int[4*arr.length];
    }
    public void build(int index, int low, int high){
        if(low==high){
            this.segmentTree[index] = this.arr[low];
            return;
        }
        int mid = low + (high-low)/2;
        build(2*(index)+1,low,mid);
        build(2*(index)+2,mid+1,high);
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }
    public int query(int index, int low, int high, int l, int r){
        if (low >= l && high <= r) {
            return segmentTree[index];
        }
        if (high < l || low > r) {
            return 0;
        }
        int mid = (low + high) / 2;
        int left = query(2 * index + 1, low, mid, l, r);
        int right = query(2 * index + 2, mid + 1, high, l, r);
        return left + right;
    }
    public void update(int index, int low, int high, int pos, int val) {
        if (low == high) {
            segmentTree[index] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if (pos <= mid) {
            update(2 * index + 1, low, mid, pos, val);
        } else {
            update(2 * index + 2, mid + 1, high, pos, val);
        }
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }
}