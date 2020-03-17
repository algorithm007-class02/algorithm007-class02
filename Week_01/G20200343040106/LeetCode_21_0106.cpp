class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(!l2)
            return l1;
        if(!l1)
            return l2;
        ListNode* cur;
        if(l1->val>l2->val){
            cur = l2;
            l2 = l2->next;
        }else{
            cur = l1;
            l1 = l1->next;
        }
        cur->next = mergeTwoLists(l1,l2);
        return cur;
    }
};
