package com.karn.leetcode;

//TODO : UNSOLVED
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        return maxPath(root,root.val);
    }

    private int maxPath(TreeNode node,int val) {
        if(node.left==null&&node.right==null){
            return val;
        }
        if(node.left==null){
            return Math.max(val,maxPath(node.right,val+node.right.val));
        }
        if(node.right==null){
            return Math.max(val,maxPath(node.left,val+node.left.val));
        }
        int rightMax = Math.max(val,maxPath(node.right,val+node.right.val));
        int rightMaxWithoutVal = maxPath(node.right,node.right.val);
        rightMax = Math.max(rightMax,rightMaxWithoutVal);
        int leftMax = Math.max(val,maxPath(node.left,val+node.left.val));
        int leftMaxWithoutVal=maxPath(node.left,node.left.val);
        leftMax = Math.max(leftMaxWithoutVal,leftMax);
        int rightMaxWithLeftMax = val+rightMax+leftMax;
        int leftWithVal = val+leftMax;
        int rightWithVal = val+rightMax;
        int max = Math.max(leftWithVal, rightWithVal);
        int max1 = Math.max(max, rightMaxWithLeftMax);
        return Math.max(Math.max(rightMax,leftMax),max1);
    }


    class TreeNode {
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
    }
}
