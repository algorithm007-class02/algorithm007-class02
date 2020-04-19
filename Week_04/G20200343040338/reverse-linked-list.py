"""
>>> head = Node('a', Node('b', Node('c', Node('d'))))
>>> reversed = reverse(head)
>>> reversed
d -> c -> b -> a -> None
>>>
>>> head = Node('a', Node('b', Node('c', Node('d'))))
>>> reversed = reverse2(head)
>>> reversed
d -> c -> b -> a -> None
"""
from node import Node


def reverse(head):
    reversed = None

    while head:
        head.next, reversed, head = reversed, head, head.next

    return reversed


def reverse2(head, reversed=None):
    if not head:
        return reversed

    next, head.next = head.next, reversed
    return reverse2(next, head)
