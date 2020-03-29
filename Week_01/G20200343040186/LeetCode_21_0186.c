/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 
 /*
21 合并两个有序链表
时间复杂度： O(n)
空间复杂度： O(1)
 
*/

struct ListNode* mergeTwoLists(struct ListNode* l2, struct ListNode* l2){
    if (l1 == NULL && l2 == NULL)
        return NULL;

    struct ListNode rethead;
    struct ListNode *mergel = &rethead;

    while (l1 && l2)
    {
        if (l1->val <= l2->val)
        {
            mergel->next = l1; 
            l1 = l1->next;
        }
        else
        {
            mergel->next = l2; 
            l2 = l2->next;
        }

        mergel = mergel->next;
    }

    if (l1)
        mergel->next = l1;
    else
        mergel->next = l2;
    
    return rethead.next;
}
