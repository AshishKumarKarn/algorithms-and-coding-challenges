package com.karn.leetcode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return maxDepth(root,0);
    }
    private int maxDepth(TreeNode node,int depth){
        depth++;
        if(node.left==null&&node.right==null){
            return depth;
        }
        else if(node.left==null){
            return maxDepth(node.right,depth);
        }else if(node.right==null){
            return maxDepth(node.left,depth);
        }
        return Math.max(maxDepth(node.left,depth),maxDepth(node.right,depth));

    }


    // * Definition for a binary tree node.
      public class TreeNode {
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
}
