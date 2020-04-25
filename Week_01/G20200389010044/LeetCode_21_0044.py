# 1. 双指针 - 从前往后
#    用一个哨兵结点，如果值小则接到结点后

# 2. 递归
#   边界条件 - 缩小规模 - 调用自身
#   merget(l1,l2) = min + merge(min.next, another)
#   例如l1目前最小，则l1.next = merge(l1.next, l2)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 递归
        # if l1 is None:
        #     return l2
        # elif l2 is None:
        #     return l1
        # elif l1.val < l2.val:
        #     l1.next = self.mergeTwoLists(l1.next, l2)
        #     return l1   # l1 作为新链表的头结点返回
        # else:
        #     l2.next = self.mergeTwoLists(l1, l2.next)
        #     return l2   # l2 作为新链表的头结点返回
        
        # 递归 - 代码紧凑版
        if l1 and l2:
            if l1.val > l2.val: l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1 or l2


        
        # 双指针迭代
        # dummy = ListNode(-1)
        # head = dummy
        # while l1 != None and l2 != None:
        #     if l1.val < l2.val:
        #         dummy.next = l1
        #         l1 = l1.next
        #         dummy = dummy.next
        #     else:
        #         dummy.next = l2
        #         l2 = l2.next
        #         dummy = dummy.next

        # if l1 != None:
        #     dummy.next = l1
        # if l2 != None:
        #     dummy.next = l2
        # return head.next