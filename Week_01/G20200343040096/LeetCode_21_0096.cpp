/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		//创建一个虚拟的头节点， 主要是可以减少代码行数  这里就不需要讨论该用l1还是l2的第一个节点作为新链表的第一个节点了
        ListNode* dummy = new ListNode(0);
        ListNode* cur = dummy;
        while(l1 && l2){
            if(l1->val <= l2->val){
                cur->next = l1;
                l1 = l1->next;
            }else{
                cur->next = l2;
                l2 = l2->next;
            }
            cur = cur->next;
        }
        if(l1) cur->next = l1;
        if(l2) cur->next = l2;
        return dummy->next;
    }
};

//递归
// class Solution {
// public:
//     ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
//         if(!l1) return l2;
//         if(!l2) return l1;
//         if(l1->val <= l2->val){
//             l1->next = mergeTwoLists(l1->next, l2);
//             return l1;
//         }else{
//             l2->next = mergeTwoLists(l1, l2->next);
//             return l2;
//         }
//     }
// };