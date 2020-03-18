#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# @lc code=start
# Definition for singly-linked list.


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = (l1 or l2 or None)
        if l1 and l2:
            p1, p2 = l1, l2
            if l1.val <= l2.val:
                head = l1
                p1 = p1.next
            else:
                head = l2
                p2 = p2.next
            p_merged = head
            while p1 and p2:
                if p1.val <= p2.val:
                    p_merged.next = p1
                    p1 = p1.next
                else:
                    p_merged.next = p2
                    p2 = p2.next
                p_merged = p_merged.next
            if head:
                if p1:
                    p_merged.next = p1
                else:
                    p_merged.next = p2
        return head

# @lc code=end
