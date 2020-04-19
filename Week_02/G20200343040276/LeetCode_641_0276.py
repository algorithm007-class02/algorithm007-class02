def __init__(self, k: int):
        self.q = collections.deque(maxlen=k)

    def insertFront(self, value: int) -> bool:
        return len(self.q) < self.q.maxlen and (self.q.appendleft(value) or True)

    def insertLast(self, value: int) -> bool:
        return len(self.q) < self.q.maxlen and (self.q.append(value) or True)

    def deleteFront(self) -> bool:
        return self.q and (self.q.popleft() or True)
    
    def deleteLast(self) -> bool:
        return self.q and (self.q.pop() or True)
        
    def getFront(self) -> int:
        return not self.q and -1 or self.q[0]
    
    def getRear(self) -> int:
        return not self.q and -1 or self.q[-1]

    def isEmpty(self) -> bool:
        return not self.q

    def isFull(self) -> bool:
        return len(self.q) == self.q.maxlen