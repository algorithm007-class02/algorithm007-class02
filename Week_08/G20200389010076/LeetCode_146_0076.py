#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU缓存机制
#

# @lc code=start
class Node:
    def __init__(self,key,value,next=None,prev=None):
        self.key=key
        self.value=value
        self.next=next
        self.prev=prev

class DoubleList:
    def __init__(self):
        self.head=Node(-1,-1)
        self.tail=Node(-1,-1)
        self.head.next=self.tail
        self.tail.prev=self.head
        self.size=0

    def addFirst(self,node):
        node.next=self.head.next
        node.next.prev=node
        self.head.next=node
        node.prev=self.head
        self.size+=1
    
    def remove(self,node):
        node.next.prev=node.prev
        node.prev.next=node.next
        self.size-=1
    
    def removeLast(self):
        if self.head.next==self.tail:
            return None
        last_node=self.tail.prev
        self.remove(last_node)
        return last_node
    
    def getSize(self):
        return self.size
        
        

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity=capacity
        self.cache=DoubleList()
        self.dict=dict()
        

    def get(self, key: int) -> int:
        if key not in self.dict:
            return -1
        node=self.dict[key]
        self.put(node.key,node.value)
        return node.value
        


    def put(self, key: int, value: int) -> None:
        if key in self.dict:
            self.cache.remove(self.dict[key])
        elif self.capacity==self.cache.getSize():
            last_node=self.cache.removeLast()
            self.dict.pop(last_node.key)
        node=Node(key,value)
        self.dict[key]=node
        self.cache.addFirst(node)
        

        



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end



# class Node:
#     def __init__(self,key,val,next=None,prev=None):
#         self.key=key
#         self.val=val
#         self.next=next
#         self.prev=prev
        

# class DoubleList:
#     def __init__(self):
#         self.head=Node(-1,-1)
#         self.tail=Node(-1,-1)
#         self.head.next=self.tail
#         self.tail.prev=self.head
#         self.size=0

#     def addFirst(self,x):
#         x.prev=self.head
#         x.next=self.head.next
#         self.head.next.prev=x
#         self.head.next=x
#         self.size+=1
    
#     def remove(self,x):
#         x.next.prev=x.prev
#         x.prev.next=x.next
#         self.size-=1
    
#     def removeLast(self):
#         if self.size==0:
#             return None
#         last_node=self.tail.prev
#         self.remove(last_node)
#         return last_node
    
#     def getSize(self):
#         return self.size

        

# class LRUCache:

#     def __init__(self, capacity: int):
#         self.capacity=capacity
#         self.map=dict()
#         self.cache=DoubleList()

#     def get(self, key: int) -> int:
#         if key not in self.map:
#             return -1
#         val=self.map[key].val
#         self.put(key,val)
#         return val


#     def put(self, key: int, value: int) -> None:
#         new_item=Node(key,value)
#         if key in self.map:
#             self.cache.remove(self.map[key])
#         elif self.cache.getSize()==self.capacity:
#                 last_node=self.cache.removeLast()
#                 self.map.pop(last_node.key)
#         self.cache.addFirst(new_item)
#         self.map[key]=new_item