学习笔记
## 树、二叉树、二叉搜索树
链表是特殊化的树，树是特殊化的图。

### 二叉树的遍历：

前序遍历（Pre-order）：根 -> 左 -> 右
中序遍历（In-order）：左 -> 中 -> 右
后续遍历（Post-order）：右 -> 中 -> 左

二叉搜索树（Binary Search Tree）：

也叫二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree）
左子树上所有节点的值都小于它的根节点值
右子树上所有节点的值都大于它的根节点值
中序遍历：升序排列

二叉树操作：

查找
插入
删除：取第一个大于该节点的节点替代该节点
时间复杂度：查找、插入、删除都为 O(logN)
参考：VisuAlgo - Binary Search Tree, AVL Tree

## 堆（Heap）
可以快速找到一堆数中最大或最小值的数据结构。
根节点最大的堆叫大顶堆或大根堆，根节点最小的堆叫大顶堆或小根堆。

时间复杂度：

查找最大（最小）值：O(1)
插入：O(logN) 或 O(1)
删除：O(logN)
实现：
二叉堆、多项式堆、（严格）斐波那契堆等。
参考：Heap

二叉堆
性质：

通过完全二叉树实现
树中任意节点的值>=子节点的值（大顶堆）
实现：

索引为 i 的左孩子的索引为 2^i + 1
索引为 i 的右孩子的索引为 2^i + 2
索引为 i 的父节点的索引是 floor((i - 1) / 2)
插入操作：

新元素一律插入到堆尾部
依次向上调整整个堆的结构直到根部（HeapifyUp）
删除堆顶操作：

将堆尾元素替换到顶部
依次从根部向下调整整个堆的结构（HeapifyDown）
递归
递归的代码模板：

recursion terminator
process logic in current level
drill down
revert the current level states
思维要点：

不要人肉递归
拆解为重复子问题
数学归纳法思维
分治、回溯
一种特殊的递归

分治代码模板：

recursion terminator
prepare data
conquer subproblems
process and generate the final result
revert the current level states
回溯：
现有的分步不能得到答案时，取消上一步或几步，再通过其他分步寻找答案