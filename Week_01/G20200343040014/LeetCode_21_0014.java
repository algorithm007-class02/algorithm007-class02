class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode tempNode = node;
        while (l1 != null && l2 != null) {            
            if (l1.val > l2.val) {
                tempNode.next = new ListNode(l2.val);
                l2 = l2.next; 
            }else{
                tempNode.next = new ListNode(l1.val);  
                l1 = l1.next;             
            }
            tempNode = tempNode.next;                           
        }
        if (l1 != null) {
            tempNode.next = l1;
        }else{
            tempNode.next = l2;
        }
        return node.next;
    }
}