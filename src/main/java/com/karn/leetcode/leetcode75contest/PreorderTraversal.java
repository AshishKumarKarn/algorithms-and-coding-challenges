package com.karn.leetcode.leetcode75contest;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        return preorderT(root,result);
    }

    private List<Integer> preorderT(Node node, List<Integer> result){
        if(node==null){
            return result;
        }
        result.add(node.val);
        if(node.children!=null){
            for(Node n:node.children){
                preorderT(n,result);
            }
        }
        return result;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

