package com.karn.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
//TODO: UNRESOLVED
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        System.out.println(root);
        SerializeAndDeserializeBinaryTree OBJECT = new SerializeAndDeserializeBinaryTree();
        String serialize = OBJECT.serialize(root);
        System.out.println(serialize);
        System.out.println(OBJECT.deserialize(serialize));

    }

    public static final String SEPARATOR = ",";
    public static final String NULL = "null";

    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serializeHelper(root,stringBuilder );
         return stringBuilder.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if(node==null){
            sb.append(NULL).append(SEPARATOR);
            return;
        }
        sb.append(node.val).append(SEPARATOR);
        serializeHelper(node.left,sb);
        serializeHelper(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(SEPARATOR);

        if(split.length==0||split[0].equals(NULL)){
            return null;
        }
        //convert to int array
        TreeNode[] treeNodeArray=new TreeNode[split.length-1];
        for (int i = 0; i < treeNodeArray.length; i++) {
            if(!split[i].equals(NULL)){
                treeNodeArray[i] = new TreeNode(Integer.parseInt(split[i]));
            }
        }

        TreeNode node=treeNodeArray[0];
        boolean left=true;
        TreeNode operatingNode = node;
        //last element would be empty string, so iterate 1 less than last element
        int nullCount=0;
        for (int i = 1; i < treeNodeArray.length; i++) {
            if(treeNodeArray[i]==null){
                //flip the insertion side
                left = !left;
                ++nullCount;
                if(nullCount==2){
                    //shift operating node to parent node
                    operatingNode = treeNodeArray[(i/2+1)-1];
                    left=!left;
                    nullCount=0;
                }
                continue;
            }

            TreeNode newNode= treeNodeArray[i];
            if(left){
                operatingNode.left = newNode;
            }else{
                operatingNode.right = newNode;
            }
            operatingNode = newNode;
            left = !left;
        }
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            sb.append("[");
            queue.add(this);
            stringifyTree(sb);
            return sb.substring(0, sb.length() - 1)+"]";
        }

        private void stringifyTree(StringBuilder sb) {
            while(!queue.isEmpty()){
                TreeNode poll = queue.poll();
                sb.append(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }else{
                    sb.append(NULL).append(SEPARATOR);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }else{
                    sb.append(NULL).append(SEPARATOR);
                }
            }
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
    }
}
