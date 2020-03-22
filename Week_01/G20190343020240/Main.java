package com.company;

class solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2){
            return null;
        }else if(null != l1 && null == l2){
            return l1;
        }else if(null == l1 && null != l2){
            return l2;
        }else{
            if(l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else{
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    };
}