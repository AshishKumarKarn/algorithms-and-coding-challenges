package com.karn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PathSumIII {
    public static void main(String[] args) {
        /*TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(-2);*/
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(-1);
        treeNode.right = new TreeNode(-3);
        treeNode.right.left = new TreeNode(-2);
        System.out.println(new PathSumIII().pathSum(treeNode, 1));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }


        @Override
        public String toString() {
            return val + "";
        }
    }


    // Map for keeping track of (PrefixSum, timesPrefixSumSeen) during traversal
    Map<Long, Integer> hmap;
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count = 0;

        dfs(root, 0, targetSum);

        return count;
    }

    private void dfs(TreeNode root, long prefixSum, int targetSum) {
        // base case
        if (root == null) return;


        prefixSum += root.val;

        // If map contains a sum equal to (prefixSum - targetSum), we need to increment count that many times
        if (hmap.containsKey(prefixSum-targetSum)) {
            count += hmap.get(prefixSum-targetSum);
        }

        // There can be cases when the prefixSum is directly equal to targetSum, we need to increment count
        if (targetSum == prefixSum) {
            count++;
        }

        // Update the prefixSum till current node and it's count
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

        // Recurse
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        // Backtrack
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);

    }
}
