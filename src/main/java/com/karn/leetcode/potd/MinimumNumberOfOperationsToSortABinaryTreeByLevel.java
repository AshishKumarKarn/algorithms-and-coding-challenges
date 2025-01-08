package com.karn.leetcode.potd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//lc : 2471
public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);



        MinimumNumberOfOperationsToSortABinaryTreeByLevel obj = new MinimumNumberOfOperationsToSortABinaryTreeByLevel();
        System.out.println(obj.minimumOperations(root));
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minimumOperations(TreeNode root) {
        Queue<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(1,root));
        Map<Integer, List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            LevelNode ln= queue.poll();
            List<Integer> list =  map.getOrDefault(ln.level,new ArrayList<>());
            list.add(ln.node.val);
            map.put(ln.level, list);
            if(ln.node.left!=null){
                queue.add(new LevelNode(ln.level+1, ln.node.left));
            }
            if(ln.node.right!=null){
                queue.add(new LevelNode(ln.level+1, ln.node.right));
            }
        }
        int swaps = 0;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            swaps += countSwaps(entry.getValue());
        }
        return swaps;
    }
    class LevelNode{
        int level;
        TreeNode node;
        LevelNode(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
    private int countSwaps(List<Integer> numbers){
        Map<Integer, int[]> map = new HashMap<>();
        Queue<int[]> locations = new PriorityQueue<>((a, b)->b[0]-a[0]);
        for(int i=0;i<numbers.size();i++){
            int[] location = new int[]{numbers.get(i),i};
            locations.add(location);
            map.put(i, location);
        }
        int j = numbers.size()-1;
        int swap = 0;
        while(!locations.isEmpty()){
            int[] location = locations.poll();
            if(j!=location[1]){
                swap++;
                int swapLoc = location[1];
                location[1] = j;
                int[] toSwap = map.get(j);
                toSwap[1] = swapLoc;

                map.put(j, location);
                map.put(swapLoc, toSwap);
            }
            j--;

        }
        return swap;
    }
}


