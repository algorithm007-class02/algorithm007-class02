class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class LeetCode_21_0052 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null){
            return l1;
        } else if(l1.val > l2.val) {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }
}
