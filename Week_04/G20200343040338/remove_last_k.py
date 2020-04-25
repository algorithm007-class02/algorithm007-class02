"""
>>> l = Node(1, Node(2, Node(3, Node(4, Node(5)))))
>>> remove_last_k(l, 1)
1 -> 2 -> 3 -> 4 -> None
>>>
>>> remove_last_k(l, 2)
1 -> 2 -> 4 -> None
>>>
>>> remove_last_k(l, 3)
2 -> 4 -> None
>>>
>>> remove_last_k(l, 3)
2 -> 4 -> None
"""
from node import Node


def remove_last_k(l, k):
    head = slow = fast = Node(None, l)

    while fast and k >= 0:
        fast = fast.next
        k -= 1

    if k >= 0:
        return head.next

    while fast:
        fast = fast.next
        slow = slow.next

    slow.next = slow.next.next

    return head.next
