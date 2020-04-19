

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null)
        return l2;
    if(l2 == null)
        return l1;
    if(l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
//由于对于链表还不太熟悉，直接看了题解。
//思路是递归添加元素，对比l1和l2的元素大小，当一方的next为空，则直接将另一方剩余的元素添加到之后。