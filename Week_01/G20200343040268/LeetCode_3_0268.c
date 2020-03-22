struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if (l1 == NULL) return l2;
    if (l2 == NULL) return l1;
    struct ListNode* head = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode*l = head;
    while (l1 != NULL && l2 != NULL){
        if (l1->val < l2->val){
                head->next = l1;
                l1 = l1->next;
        }else {
            head->next = l2;
            l2 = l2->next;
        }
        head = head->next;
    }
    if (l1 == NULL){
        head->next = l2;
    }
    if (l2 == NULL){
        head->next = l1;
    }
    return l->next;
}
