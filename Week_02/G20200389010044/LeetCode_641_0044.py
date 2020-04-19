class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        # 保证开始和结束两个指针不会碰撞，所以长度设置为k+1
        self._data = [0] * (k+1)
        self._front = 1
        self._rear = 0
        self._size = 0
        self._capacity = k

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        # 检查是否已满
        if self.isFull():
            return False
        else:
            # 队列未满，处理插入
            self._front -= 1
            self._data[self._front] = value
            self._size += 1
            return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        else:
            self._rear += 1
            self._data[self._rear] = value
            self._size += 1
            return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        else:
            self._front += 1
            self._size -= 1
            return True
        

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        else:
            self._rear -= 1
            self._size -= 1
            return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty():
            return -1
        else:
            return self._data[self._front]       

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty():
            return -1
        else:
            return self._data[self._rear]
        

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        if self._size == 0:
            return True
        else:
            return False

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        if self._size == self._capacity:
            return True
        else:
            return False

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