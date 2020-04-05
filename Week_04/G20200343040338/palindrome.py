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
    l = []
    while s:
        l.append(s.value)
        s = s.next

    low, high = 0, len(l) - 1
    while low < high:
        if l[low] != l[high]:
            return False
        low += 1
        high -= 1

    return True
