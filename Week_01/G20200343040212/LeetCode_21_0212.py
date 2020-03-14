# -*- coding: utf-8 -*-
# @Time    : 2020-03-14 20:09 
# @Author  : peniridis
# @Version : V0.1
# @File    : leetcode_21.py
# @Desc    :
# 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
#
#  示例：
#
#  输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
#
#  Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
            递归实现
        :param l1: 有序链表
        :param l2: 有序链表
        :return: 合并后新链表
        """
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
