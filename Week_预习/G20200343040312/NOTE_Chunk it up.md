	一维数据结构：
		基础：数组array、链表linked list
		高级：栈stack、队列queue、双端队列deque、集合set、映射map(hash or map)...
			
	二维数据结构：
		基础：树tree，图
		高级：二叉搜索树binary search tree  (red-black tree)，堆heap，并查集disjoint set，字典数Trie...
		(二维是一维的泛化，如，一维的链表。当它的分叉有两个的时候就变成了二维的数据结构，树)
				
	特殊数据结构：
		位运算 Bitwise，布隆过滤器BloomFitter
		缓存LRU Cache(在此基础上会给大家讲一些不同替换算法的cache是什么)
		(在树的基础上加了许多特殊判断和约定条件，如，二叉搜索树：根节点大于左子树且小于它的右子树的全部节点)
			
	数据结构讲完后，在算法方面主要是八大点
		前三点：(前三点类似集合中的公理，是算法的基石)
		1. if-else(逻辑的切换)、Switch(跳转语句)---Branch(逻辑的切换)
		2. (循环)for LOOP、which LOOP
		3. Recursion(递归)(divide & Conquer (翻译为"分为治之"),Backtrace(翻译为"回溯"))
		(到了最后，任何高级的算法或数据结构都会转换成if-else，for LOOP或者递归，因为这些算法和数据结构都是最"朴素的"，没有任何人工智能的成分在里面。到了学完所有知识体系之后，化繁为简之后，它的根本就是找到它的重复单元)
				
	后五点：
		1. 搜索Search；高级搜索：深度优先搜索Deep first search，广度优先搜索Breadth first search，启发式搜索A*...
		2. 动态规划 dynamic programming
		3. 二分查找 binary 	Search --- 对于一个有序的数组，很快找到你要的目标节点
		4. 贪心
		5. 数学 Math ，几何 Geometry
				
		(在头脑中回忆每种算法思想和代码模板)
		对于已有的两种脑图，应该先把概念点熟悉起来，多反复回顾，将常用的情况，时间复杂度，熟记于心。这样就会对知识体系有清晰的认识。