package com.karn.leetcode.leetcode75contest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> subResult=new ArrayList<>();
            TreeNode node;
            List<TreeNode> list=new ArrayList<>();
            while((node=queue.poll())!=null){
                subResult.add(node.val);
                list.add(node);
            }
            for(TreeNode t:list){
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
            }
            result.add(subResult);
        }
        return result;
    }
}
 class TreeNode {
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
