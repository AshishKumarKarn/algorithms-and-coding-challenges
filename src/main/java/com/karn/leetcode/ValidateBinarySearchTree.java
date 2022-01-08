package com.karn.leetcode;

public class ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left, root.val, Long.MIN_VALUE)
                && isValidBST(root.right, Long.MAX_VALUE, root.val);
    }

    private boolean isValidBST(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }
        boolean leftSubTree = true;
        boolean rightSubTree = true;

        if (node.val <= min || node.val >= max) {
            return false;
        } else {
            if (node.left != null) {
                leftSubTree = isValidBST(node.left, node.val, min);
            }
            if (node.right != null) {
                rightSubTree = isValidBST(node.right, max, node.val);
            }
        }

        return leftSubTree && rightSubTree;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
