"""
>>> s0 = None
>>> s1 = Node('a')
>>> s2 = Node('a', Node('b'))
>>> s3 = Node('a', Node('b', Node('a')))
>>> s4 = Node('a', Node('b', Node('b', Node('a'))))
>>>
>>> [isPalindrome(x) for x in (s0, s1, s2, s3, s4)]
[True, True, False, True, True]
"""
from node import Node


def isPalindrome(s):
    slow = fast = s
    prev = None

    # 找到中间结点并翻转做半部分结点
    while fast and fast.next:
        fast = fast.next.next
        slow.next, prev, slow = prev, slow, slow.next

    # 比较左右两部分字符串
    left, right = prev, slow.next if fast else slow
    while left and right:
        if left.value != right.value:
            return False
        left, right = left.next, right.next

    return True
