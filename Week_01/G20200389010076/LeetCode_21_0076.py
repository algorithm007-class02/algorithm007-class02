#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2) :
        head=ListNode(-1)
        prev=head
        while l1 and l2:
            if l1.val>=l2.val:
                prev.next=l2
                l2=l2.next
            else:
                prev.next=l1
                l1=l1.next
            prev=prev.next
        prev.next=l1 if l1 is not None else l2
        return head.next
# @lc code=end

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

if __name__ == "__main__":
    so=Solution()
    head_a=ListNode(1)
    a=head_a
    a.next=ListNode(2)
    a=a.next
    a.next=ListNode(4)
    head_b=ListNode(1)
    b=head_b
    b.next=ListNode(3)
    b=b.next
    b.next=ListNode(4)
    # head_a=ListNode(1)
    # head_b=ListNode(2)
    result=so.mergeTwoLists(head_a,head_b)
    print(result)

#自己想的方法
        # p1,p2=l1,l2
        # head1,head2=None,p2
        # if not p1:  return p2
        # while p1 and p2:
        #         if p1.val>=p2.val:
        #             head2,p2.next=p2.next,p1
        #             if head1: head1.next=p2
        #             else: l1=p2
        #             head1,p2=p2,head2
        #         else:
        #             break
        #     if head1: head1=head1.next
        #     else: head1=p1
        #     p1=p1.next
        # if head2: head1.next=head2
        # return l1