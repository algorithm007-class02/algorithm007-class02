/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p=l1,q=l2,r;
        r=q;
        while(q.next!=null){
            //l2比l1小
            if(q.val<=p.val){
                q=q.next;
                r.next=p;
                r=q;
            }else{//l2比l1大
                while(p.next!=null && p.next.val<=q.val)
                    p=p.next;
                if(p.next!=null){
                    q=q.next;
                    r.next=p.next;
                    p.next=r;
                    r=q;
                }else{//l2所有结点都比l1大，连接后跳出循环即可
                    p.next=r;
                    break;
                }
            }
            q=q.next;
        }
        return l1;
    }
}