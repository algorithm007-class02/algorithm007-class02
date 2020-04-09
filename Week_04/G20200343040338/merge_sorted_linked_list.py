"""
>>> h1 = Node(1, Node(3, Node(5)))
>>> h2 = Node(2, Node(4, Node(6, Node(8, Node(10)))))
>>> result = merge(h1, h2)
>>> result
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8 -> 10 -> None
"""
from node import Node


def merge(h1, h2):
    head = tail = Node(None)

    while h1 and h2:
        if h1.value < h2.value:
            tail.next = h1
            h1 = h1.next
        else:
            tail.next = h2
            h2 = h2.next
        tail = tail.next

    if h1: tail.next = h1
    if h2: tail.next = h2

    return head.next
