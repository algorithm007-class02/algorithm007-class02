# 学习笔记

## Stack & Queue 

- Stack：先入后出FILO；添加、删除皆为O(1)
- Queue： 先入先出FIFO；添加、删除皆为O(1)F

## Deque（双端队列 Double ended queue）

1. 两端可以进出的Queue
2. 插入和删除都是O(1)

## Priority Queue (优先队列)

1. 插入操作：O(1)
2. 取出操作：O(logN) - 按照元素的优先级取出
3. 底层具体实现的数据结构较为多样和复杂： heap，bst, treap