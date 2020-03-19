/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4 
*/
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    struct ListNode head = {0};
    head.next = NULL;
    struct ListNode *move = &head;

    while(NULL != l1 && NULL != l2)
    {
        if(l1->val <= l2->val)
        {
            move->next = l1;
            l1 = l1->next;
        }
        else
        {
            move->next = l2;
            l2 = l2->next;
        }

        move = move->next;
    }

    if(NULL != l1)
    {
        move->next = l1;
    }
    else
    {
        move->next = l2;
    }
    return head.next;
}