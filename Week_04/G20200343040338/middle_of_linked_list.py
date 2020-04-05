"""
>>> middle(None)
>>> middle(Node('a'))
a -> None
>>> middle(Node('a', Node('b')))
b -> None
>>> middle(Node('a', Node('b', Node('c'))))
b -> c -> None
"""
from node import Node


def middle(head):
    slow = fast = head

    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next

    return slow
