package com.karn.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
//TODO: unresolved
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE<(-1*Math.pow(10,9)));
        TreeNode root1=new TreeNode(3);
        root1.left=new TreeNode(4);
        TreeNode root2 = root1.left;
        root1.right=new TreeNode(5);
        root2.left=new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(0);
        System.out.println(new SubtreeOfAnotherTree().isSubtree(root1,root2));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null){
            return true;
        }
        if(root==null||subRoot==null){
            return false;
        }
        parentQueue.add(root);
        childQueue.add(subRoot);
        return checkSubTree();
    }
    Set<Integer> subNodeMemory = new HashSet<>();
    Queue<TreeNode> parentQueue =new ArrayDeque<>();
    Queue<TreeNode> childQueue =new ArrayDeque<>();

    private boolean checkSubTree() {
        while(!parentQueue.isEmpty()&& !childQueue.isEmpty()) {
            TreeNode parent = this.parentQueue.poll();
            TreeNode child = this.childQueue.poll();

            //don't explore parent node is the node is already visited as child node
            //in this case, for valid subtree, the child tree should also have null legs
            if(!subNodeMemory.contains(parent.val)){
                if(parent.left!=null){
                    parentQueue.add(parent.left);
                }
                if(parent.right!=null){
                    parentQueue.add(parent.right);
                }
            }

            subNodeMemory.add(child.val);
            if(child.left!=null){
                childQueue.add(child.left);
            }
            if(child.right!=null){
                childQueue.add(child.right);
            }
        }
        return (parentQueue.isEmpty() && childQueue.isEmpty());
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
    }
}
