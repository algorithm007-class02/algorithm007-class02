/*
LeetCode
（环形链表）题目141描述：
给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 
如果 pos 是 -1，则在该链表中没有环。
*/

//步长差的设置应该可以优化，步子差大些运行快但可能无法收敛，需要一些辅助判断。这个后面再研究

// struct ListNode {
//      int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };

class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode* slow = head;//快指针
        ListNode* fast = head;//慢指针
        while (head != NULL) {
            if (fast->next != NULL && fast->next->next != NULL) {
                fast = fast->next->next;
                slow = slow->next;
            } else {
                return false;
            }
            if (slow == fast) {//快慢指针相遇即是环
                return true;
            }
        }
        return false;
    }
};