class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* dumpy = new ListNode(0);
        ListNode* node = dumpy;

        while (l1 != NULL && l2 != NULL) {
            if (l1->val < l2->val) {
                node->next = l1;
                l1 = l1->next;
                node = node->next;
            } else {
                node->next = l2;
                l2 = l2->next;
                node = node->next;

            }
        }

        if (l1 != NULL) {
            node->next = l1;
            l1 = l1->next;
            node = node->next;
        } else if (l2 != NULL) {
            node->next = l2;
            l2 = l2->next;
            node = node->next;
        }

        return dumpy->next;
    }
};
