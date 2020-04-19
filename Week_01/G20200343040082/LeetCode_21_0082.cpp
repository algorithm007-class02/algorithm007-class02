struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x): val(x), next(NULL) {}
};

// 1递归
ListNode * mergeTwoLists(ListNode *l1, ListNode *l2) {
    if (l1 == NULL) 
        return l2;

    if (l2 == NULL)
        return l1;

    if (l1->val > l2->val) {
        l2->next = mergeTwoLists(l1, l2->next);
        return l2;
    } else {

        l1->next = mergeTwoLists(l1->next, l2);
        return l1;
    }
}
// 2非递归
ListNode * mergeTwoLists(ListNode * l1, ListNode *l2) {

    if (l1 == NULL) return l2;
    if (l2 == NULL) return l1;

    ListNode *head, *temp;

    if (l1->val > l2->val) {
        head = l2;
        l2 = l2->next;
    } else {
        head = l1;
        l1 = l1->next;
    }
    temp = head;

    while (l1 && l2) {
        if (l1->val > l2->val) {
            temp->next = l2;
            l2 = l2->next;
        } else {
            temp->next = l1;
            l1 = l1->next;
        }
        temp = temp->next;
    }

    if (l1) 
        temp->next = l1;

    if (l2)
        temp->next = l2;
    
    return head;
}