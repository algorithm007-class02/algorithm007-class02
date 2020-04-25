/**
 * 21.合并两个有序链表
 * 
 * */

/**
 * Definition for singly-linked list.
 * 
 */
struct ListNode {
    int val;
    struct ListNode *next;
};


struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode head;
    head.next = NULL;

    struct ListNode* prev = &head;
    struct ListNode* pmin = NULL;
    while(l1 && l2) {
        if(l1->val < l2->val) {
            pmin = l1;
            l1 = l1->next;
        }
        else {
            pmin = l2;
            l2 = l2->next;
        }
        prev->next = pmin;
        prev = pmin;
    }
    if(l1) {
        prev->next = l1;
    }
    else {
        prev->next = l2;
    }
    return head.next;
}