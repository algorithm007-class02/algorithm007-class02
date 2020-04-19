"""
>>> l0 = None
>>> l1 = Node('a')
>>> l2 = Node('a'); l2.next = l2
>>> l3 = Node('a', Node('b'))
>>> l4 = Node('a', Node('b')); l4.next.next = l4
>>> l5 = Node('a', Node('b', Node('c')))
>>> l6 = Node('a', Node('b', Node('c'))); l6.next.next.next = l6.next
>>> [detect_ring(l) for l in (l0, l1, l2, l3, l4, l5, l6)]
[False, False, True, False, True, False, True]
"""
from node import Node


def detect_ring(head):
    slow = fast = head

    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        if fast and fast.value == slow.value:
            return True

    return False
