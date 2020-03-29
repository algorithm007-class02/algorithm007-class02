from typing import List


class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.items = [0] * (k + 1)
        self.front = 0
        self.rear = 0

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False

        self.front = self._prev(self.front)
        self.items[self.front] = value

        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False

        self.items[self.rear] = value
        self.rear = self._next(self.rear)

        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False

        self.front = self._next(self.front)
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False

        self.rear = self._prev(self.rear)
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        return -1 if self.isEmpty() else self.items[self.front]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return -1 if self.isEmpty() else self.items[self._prev(self.rear)]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.front == self.rear

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self._next(self.rear) == self.front

    def _prev(self, n):
        return (n - 1 + len(self.items)) % len(self.items)

    def _next(self, n):
        return (n + 1) % len(self.items)


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()

if __name__ == '__main__':
    circularDeque = MyCircularDeque(3)

    print(circularDeque.insertLast(1))
    print(circularDeque.insertLast(2))
    print(circularDeque.insertFront(3))
    print(circularDeque.insertFront(4))
    print(circularDeque.getRear())
    print(circularDeque.isFull())
    print(circularDeque.deleteLast())
    print(circularDeque.insertFront(4))
    print(circularDeque.getFront())
