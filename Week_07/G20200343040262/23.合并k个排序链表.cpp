/*
 * @lc app=leetcode.cn id=23 lang=cpp
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
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
    //小根堆
    struct cmp {
        bool operator()(ListNode *a, ListNode *b) { return a->val > b->val; }
    };

    ListNode *mergeKLists(vector<ListNode *> &lists) {
        priority_queue<ListNode *, vector<ListNode *>, cmp> q;
        //建立大小为K的小根堆
        for (auto elem : lists) {
            if (elem)
                q.push(elem);
        }
        //设置哨兵结点
        ListNode dummy(-1);
        ListNode *p = &dummy;
        //开始出队
        while (!q.empty()) {
            ListNode *top = q.top();
            q.pop();
            p->next = top;
            p = top;
            if (top->next)
                q.push(top->next);
        }
        return dummy.next;
    }
};
// @lc code=end
