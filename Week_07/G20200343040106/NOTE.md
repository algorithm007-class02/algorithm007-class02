学习笔记

# 单词搜索Ⅱ复杂度

最坏情况下，对grid每个点，我们都要dfs一次，n*n
然后最坏情况下，每个点，我们都要上下左右去dfs。

总的时间复杂度 O(n*n*pow(4,maxsize))，其中maxsize为最长单词的长度。


# 双向BFS模板
初始条件：起始状态A，起始状态B，状态集合set:S
定义：头状态集合front(initialized with A),尾状态集合back(initialized with B)
while front非空&&back非空：
    size(front)>size(back)?swap(front,back):nothing;
    temp = front
    清空front
    loop element in temp:
        loop next in (element可转变的所有状态)
            if next in back : return 结果；
            if next in S:
                将next加入front
                将next从S中删除

return -1;//没找到


# A*模板
def AstarSearch(graph, start, end):

	pq = collections.priority_queue() # 优先级 —> 估价函数
	pq.append([start]) 
	visited.add(start)

	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
   unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)

# AVL

平衡因子：左子树高度减去右子树高度
通常为 {-1，0，1}；

通过旋转维持平衡（四种)。左旋 右旋 左右旋 右左旋



# AVL与RBTree区别
* AVL提供了更快的loos ups（查询），红黑树提供了更快的插入删除操作。
* AVL要存额外的信息，比如height，factor。而红黑树只需要额外存一个bit表示红，黑
* RB树多用在语言库种，比如map，而AVL树多用在读操作多的数据库中。



