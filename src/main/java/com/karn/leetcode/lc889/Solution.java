package com.karn.leetcode.lc889;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
    private static void preorder(TreeNode node){
        if(node!=null){
            System.out.print(node.value+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    private static void inorder(TreeNode node){
        if(node!=null){
            inorder(node.left);
            System.out.print(node.value+" ");
            inorder(node.right);
        }
    }
    private static void postorder(TreeNode node){
        if(node!=null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value+" ");
        }
    }
}
class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
    TreeNode(int value){
        this.value = value;
    }
}
/*
1 -> null
2 -> 1
4 -> 1, 2
5 -> 1, 2, 4
3 -> 1, 2, 4, 5
6 -> 1, 2, 4, 5, 3
7 -> 1, 2, 4, 5, 3, 6

1 -> null
3 -> 1
7 -> 1, 3
6 -> 1, 3, 7
2 -> 1, 3, 7, 6
5 -> 1, 3, 7, 6, 2
4 -> 1, 3, 7, 6, 2, 5

parents -> 1, 2
Children
1 -> 2,3
3 -> 7
2 -> 4
5 -> 2




 */
