package com.karn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);
        System.out.println(new HouseRobberIII().rob(treeNode));
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
        public String toString() {
            return this.val + "";
        }
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        return robSolver(root, map);
    }

    private int robSolver(TreeNode node, Map<TreeNode, Integer> map) {

        if (node == null) {
            return 0; //can't pick
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }

        int leftMax = node.left == null ? 0 : robSolver(node.left.left, map) + robSolver(node.left.right, map);
        int rightMax = node.right == null ? 0 : robSolver(node.right.left, map) + robSolver(node.right.right, map);
        int pick = node.val + leftMax + rightMax;

        int skip = robSolver(node.left, map) + robSolver(node.right, map);
        int max = Math.max(pick, skip);
        map.put(node, max);
        return max;
    }
}
