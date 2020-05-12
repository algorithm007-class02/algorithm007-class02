学习笔记

DFS 代码模板
递归
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)

非递归 用栈		
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
	
BFS 代码模板 用队列
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
	
AlphaZero Explained 围棋
https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/
棋类复杂度
https://en.wikipedia.org/wiki/Game_complexity

双向BFS模版
void bfs(...param) {
    visited1[];
    visited2[];
    queue1;
    queue2;
    while (!queue1.isEmpty && !queue2.isEmpty()) {
        // foreach less node in queue
        if (queue1.size() > queue2.size() {
            queue1 <-> queue2;
            visited1 <-> visited2;
        }
        int size = queue1.size();
        for (int i = 0; i < size; i++) {
            index = queue.poll();
            if (!visited2[index]) {
                continue;
            }
            // condition find path in visited2 return
            if (visited2[index]) {
                return;
            }
            // find path and add to queue ,set visited[index] true
            visited1[index] = true;
            queue.offer(i);
        }
    }
}

A* 模版
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

数独启发式搜索A*实现
https://leetcode-cn.com/problems/sudoku-solver/solution/qi-fa-shi-you-hua-4ms-by-wenxiang233/

8 puzzles 解法比较
https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/

相似度测量方法
https://dataaspirant.com/2015/04/11/five-most-popular-similarity-measures-implementation-in-python/