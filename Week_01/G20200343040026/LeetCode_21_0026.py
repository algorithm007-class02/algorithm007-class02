# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# 双指针遍历解法
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 == None:
            return l2

        head = start = ListNode(0)
        while l1 != None and l2 != None:
            if l1.val > l2.val:
                start.next = l2
                l2 = l2.next
            else:
                start.next = l1
                l1 = l1.next
            start = start.next

        if l1 == None:
            start.next = l2
        else:
            start.next = l1

        return head.next

# 递归解法
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1==None:
            return l2
        if l2==None or l1.val<l2.val:
            l1.next = self.mergeTwoLists(l1.next,l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1,l2.next)
            return l2

