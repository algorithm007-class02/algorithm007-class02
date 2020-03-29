# -*- coding:utf-8 -*-

import collections


class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.q = collections.deque(maxlen=k)

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        return len(self.q) < self.q.maxlen and (self.q.appendleft(value) or True)

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        return len(self.q) < self.q.maxlen and (self.q.append(value) or True)

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        return self.q and (self.q.popleft() or True)

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        return self.q and (self.q.pop() or True)

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        return not self.q and -1 or self.q[0]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return not self.q and -1 or self.q[-1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return not self.q

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.q) == self.q.maxlen


