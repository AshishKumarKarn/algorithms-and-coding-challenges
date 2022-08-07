package com.karn.leetcode.leetcode75contest;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> memory=new HashSet<>();
        if(head==null){
            return head;
        }
        ListNode pointer=head;
        ListNode result=null;
        while(pointer!=null&&!memory.contains(pointer)){
            memory.add(pointer);
            ListNode temp=pointer;
            pointer=pointer.next;
            if(pointer!=null && memory.contains(pointer)){
                result = pointer;
                break;
            }
        }
        return result;
    }
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
