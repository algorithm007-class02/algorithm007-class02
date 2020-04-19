学习笔记
# 第4周 第9课 | 深度优先搜索和广度优先搜索

## 1. 深度优先搜索、广度优先搜索的实现和特性

### 参考链接

#### [DFS 代码模板（递归写法、非递归写法）](http://shimo.im/docs/ddgwCccJQKxkrcTq)

**递归写法**

```python
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
```

 **非递归写法**

```python
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
```

#### [BFS 代码模板](http://shimo.im/docs/P8TqKHGKt3ytkYYd)

```python
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
```

## 2. 实战题目解析：二叉树的层次遍历等问题

### 实战题目

#### [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

```php
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * 方法一：dfs 递归写法
     * @param TreeNode $root
     * @return Integer[][]
     */
    function levelOrder($root) {
        if (!$root) return [];
        $this->dfs($root, 0, $res);
        return $res;
    }
    function dfs($root, $level, &$res = []) {
        if ($root) {
            if(count($res) == $level) $res[$level] = [];
            $res[$level][] = $root->val;
            $this->dfs($root->left, $level + 1, $res);
            $this->dfs($root->right, $level + 1, $res);
        }
    }
    /**
     * 方法二：bfs
     * @param TreeNode $root
     * @return Integer[][]
     */
    function levelOrder($root) {
        if (!$root) return [];
        $queue = [$root];
        $res = [];
        while ($queue) {
            $size = count($queue);
            $row = [];
            while($size--) {
                $root = array_shift($queue);
                $row[] = $root->val;
                if ($root->left) $queue[] = $root->left;
                if ($root->right) $queue[] = $root->right;
            }
            $res[] = $row;
        }
        return $res;
    }
}
```

#### [433. 最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)

```php
class Solution {

    /**
     * @param String $start
     * @param String $end
     * @param String[] $bank
     * @return Integer
     */
    function minMutation($start, $end, $bank) {
        if ($start == $end) return 0;
        $bank_hash = array_flip($bank);
        $chars = ['A', 'C', 'G', 'T'];
        $visited = [];
        $queue = [$start];
        $visited[$start] = true;
        $level = 0;
        while ($queue) {
            $size = count($queue);
            while ($size--) {
                $curr = array_shift($queue);
                if ($curr == $end) return $level;
                for ($i = 0, $len = strlen($curr); $i < $len; $i++) {
                    $old = $curr[$i];
                    foreach ($chars as $char) {
                        $curr[$i] = $char;
                        if (!$visited[$curr] && isset($bank_hash[$curr])) {
                            $queue[] = $curr;
                            $visited[$curr] = true;
                        }
                    }
                    $curr[$i] = $old;
                }
            }
            $level++;
        }
        return -1;
    }
}
```

#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

```php
class Node {
    public $res;
    public $left;
    public $right;
    function __construct($res, $left, $right){
        $this->res = $res;
        $this->left = $left;
        $this->right = $right;
    }
}
class Solution {

    /**
     * dfs
     * @param Integer $n
     * @return String[]
     */
    function generateParenthesis($n) {
        $res = [];
        $this->dfs($res, "", 0, 0, $n);
        return $res;
    }

    function dfs(&$res, $curr, $left, $right, $n) {
        if ($right == $n) {
            $res[] = $curr;
            return;
        }
        if ($left < $n) $this->dfs($res, $curr."(", $left + 1, $right, $n);
        if ($right < $left) $this->dfs($res, $curr.")", $left, $right + 1, $n);
    }
    
    /**
     * bfs
     * @param Integer $n
     * @return String[]
     */
    function generateParenthesis($n) {
        $res = [];
        if ($n == 0) return $res;
        $queue = [];
        $queue[] = new Node("", $n, $n);
 		while ($queue) {
            $node = array_shift($queue);
            if ($node->left == 0 && $node->right == 0) {
                $res[] = $node->res;
            }
            if ($node->left > 0) {
                $queue[] = new Node($node->res . "(", $node->left - 1, $node->right);
            }
            if ($node->left < $node->right && $node->right > 0) {
                $queue[] = new Node($node->res . ")", $node->left, $node->right - 1);
            }
        }
        return $res;
    }
    
    /**
     * 动态规划
     * @param Integer $n
     * @return String[]
     */
    function generateParenthesis($n) {
        
    }
}
```

```python
class Solution(object):
    def generateParenthesis(self, n):
        """
        dp
        :type n: int
        :rtype: List[str]
        """
        dp = [[] for i in range(n + 1)]
        dp[0].append('')
        for i in range(n + 1):
            for j in range(i):
                dp[i] += ['(' + x + ')' + y for x in dp[j] for y in dp[i - j - 1]]
        return dp[n]
```

#### [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)

```php
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * bfs
     * @param TreeNode $root
     * @return Integer[]
     */
    function largestValues($root) {
        $res = [];
        if (!$root) return $res;
        $queue = [$root];
        while ($queue) {
            $size = count($queue);
            $max = PHP_INT_MIN;
            while ($size--) {
                $node = array_shift($queue);
                $max = max($max, $node->val);
                if ($node->left) $queue[] = $node->left;
                if ($node->right) $queue[] = $node->right; 
            }
            $res[] = $max;
        }
        return $res;
    }
    
    /**
     * dfs
     * @param TreeNode $root
     * @return Integer[]
     */
    function largestValues($root) {
        $res = [];
        $this->dfs($root, $level, $res);
        return $res;
    }
    function dfs($root, $level, &$res) {
        if ($root) {
            if(!isset($res[$level])) $res[$level] = $root->val;
            $res[$level] = max($res[$level], $root->val);
            $this->dfs($root->left, $level + 1, $res);
            $this->dfs($root->right, $level + 1, $res);
        }
    }
}
```

### 课后作业

#### [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/)

```php
class Solution {

    /**
     * 部分用例测试超时
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function ladderLength($start, $end, $bank) {
        if ($start == $end) return 0;
        $bank_hash = array_flip($bank);
        $chars = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 
        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
        $visited = [];
        $queue = [$start];
        $visited[$start] = true;
        $level = 1;
        while ($queue) {
            $size = count($queue);
            while ($size--) {
                $curr = array_shift($queue);
                if ($curr == $end) return $level;
                for ($i = 0, $len = strlen($curr); $i < $len; $i++) {
                    $old = $curr[$i];
                    foreach ($chars as $char) {
                        $curr[$i] = $char;
                        if (!$visited[$curr] && isset($bank_hash[$curr])) {
                            $queue[] = $curr;
                            $visited[$curr] = true;
                        }
                    }
                    $curr[$i] = $old;
                }
            }
            $level++;
        }
        return 0;
    }
    
    /**
     * 双bfs
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function ladderLength($beginWord, $endWord, $wordList) {
        $word_hash = array_flip($wordList);
        if (!isset($word_hash[$endWord])) return 0;
        $queue1 = [$beginWord];
        $queue2 = [$endWord];
        $visited[$beginWord] = true;
        $n = strlen($beginWord);
        $step = 0;
        while ($queue1) {
            $step++;
            if (count($queue1) > count($queue2)) [$queue1, $queue2] = [$queue2, $queue1];
            $size = count($queue1);
            while($size--) {
                $word = array_shift($queue1);
                for($i = 0; $i < $n; $i++) {
                    $old = $word[$i];
                    for ($k = ord('a'); $k <= ord('z'); $k++) {
                        if ($old == chr($k)) continue;
                        $word[$i] = chr($k);
                        if (in_array($word, $queue2)) return $step + 1;
                        if (!$visited[$word] && isset($word_hash[$word])) {
                            $queue1[] = $word;
                            $visited[$word] = true;
                        }
                    }
                    $word[$i] = $old;
                }
            }
        } 
        return 0;
    }
}
```

```cpp
bool connect(const std::string &word1, const std::string &word2) {
    int cnt = 0;//记录不相同的字符个数
    for (int i = 0; i < word1.length(); i++) {
        if (word1[i] != word2[i]) {
            cnt++;
        }
    }
    return cnt == 1;
}
//构建邻接表
void construct_graph(std::string &beginWord,
                     std::vector<std::string> &wordList,
                     std::map<std::string,std::vector<std::string>> &graph) {
    wordList.push_back(beginWord);
    for (int i = 0; i < wordList.size(); i++) {
        graph[wordList[i]] = std::vector<std::string>();
    }
    for (int i =0; i < wordList.size(); i++) {
        for (int j = i + 1; j < wordList.size(); j++) {
            //判断是否字符相差1
            if (connect(wordList[i], wordList[j])) {
                graph[wordList[i]].push_back(wordList[j]);
                graph[wordList[j]].push_back(wordList[i]);
            }
        }
    }
}
int bfs_graph(std::string &beginWord,std::string &endWord,
              std::map<std::string,std::vector<std::string>> &graph) {
    std::queue<std::pair<std::string,int>> q;//搜索队列
    std::set<std::string> visit;//记录访问过的单词
    q.push(std::make_pair(beginWord, 1));
    visit.insert(beginWord);
    while (!q.empty()) {
        //队列头部元素
        std::string word = q.front().first;
        int step = q.front().second;
        q.pop();//弹出队头
        if (word == endWord) {
            return step;
        }
        const std::vector<std::string> &neighbors = graph[word];
        for (int i = 0; i < neighbors.size(); i++) {
            //判重并加入队列
        	if (visit.find(neighbors[i]) == visit.end()) {
                q.push(std::make_pair(neighbors[i], step + 1));
                visit.insert(neighbors[i]);
            }   
        }
    }
    return 0;
}
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		std::map<std::string,std::vector<std::string>> graph;
        construct_graph(beginWord,wordList, graph);//构建邻接表
        return bfs_graph(beginWord, endWord, graph);
    }
};

//双bfs
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordSet{wordList.begin(), wordList.end()};
        if(wordSet.find(endWord) == wordSet.end()) return 0;    
        int step = 1;
        unordered_set<string> beginSet{beginWord};
        unordered_set<string> endSet{endWord};
        while(!beginSet.empty()){
            step++;
            unordered_set<string> nextSet;
            for(auto & word : beginSet) {
                wordSet.erase(word);
            }
            for(auto & word: beginSet){
                for(int i = 0; i < word.size(); i++){
                    string nextWord = word;
                    for(char j = 'a'; j <= 'z'; j++){
                        nextWord[i] = j;
                        if(endSet.find(nextWord) != endSet.end()) return step;
                        if(wordSet.find(nextWord) != wordSet.end()){
                            nextSet.insert(nextWord);
                        }
                    }
                }
            }
            beginSet = nextSet;
            if(beginSet.size() > endSet.size()){
                swap(beginSet, endSet);
            }
        }
        return 0;
    }
};
```

#### [126. 单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/)

```php
class Solution {

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return String[][]
     */
    function findLadders($beginWord, $endWord, $wordList) {
		$ans = $paths = [];
        $wordList = array_flip($wordList);
        $paths[] = [$beginWord];
        $level = 0;
        $min_level = pow(2, 31);
        $visited = [];
        while (!empty($paths)) {
            $path = array_shift($paths);
            if (count($path) > $level) {
                foreach ($visited as $w=>$i) unset($wordList[$w]);
                $visited = [];
                if (count($path) > $min_level) break;
                $level = count($path);
            }
            $last = end($path);
            for ($i = 0; $i < strlen($last); $i++) {
                $news = $last;
                for ($k = ord('a'); $k <= ord('z'); $k++) {
                    $news[$i] = chr($k);
                    if (isset($wordList[$news])) {
                        $newpath = $path;
                        $newpath[] = $news;
                        $visited[$news] = true;
                        if ($news == $endWord) {
                            $min_level = $level;
                            $ans[] = $newpath;
                        } else {
                            $paths[] = $newpath;
                        }
                    }
                }
            }
        }
        return $ans;
    }
}
```

cpp写法

```cpp
struct Qitem {
    std::string node;
    int parent_pos;
    int step;
    Qitem(std::string node, int parent_pos, int step)
    : node(node), parent_pos(parent_pos), step(step){
        
    }
};
bool connect(const std::string &word1, const std::string &word2) {
    int cnt = 0;//记录不相同的字符个数
    for (int i = 0; i < word1.length(); i++) {
        if (word1[i] != word2[i]) {
            cnt++;
        }
    }
    return cnt == 1;
}
//构建邻接表
void construct_graph(std::string &beginWord,
                     std::vector<std::string> &wordList,
                     std::map<std::string,std::vector<std::string>> &graph) {
   int has_begin_word = 0;
    for (int i = 0; i < wordList.size(); i++) {
        if (wordList[i] == beginWord) {
            has_begin_word = 1;
        }
        graph[wordList[i]] = std::vector<std::string>();
    }
    for (int i =0; i < wordList.size(); i++) {
        for (int j = i + 1; j < wordList.size(); j++) {
            //判断是否字符相差1
            if (connect(wordList[i], wordList[j])) {
                graph[wordList[i]].push_back(wordList[j]);
                graph[wordList[j]].push_back(wordList[i]);
            }
        }
        if (has_begin_word == 0 && connect(beginWord, wordList[i])) {
            graph[beginWord].push_back(wordList[i]);
        }
    }
}
void bfs_graph(std::string &beginWord,std::string &endWord,
              std::map<std::string,std::vector<std::string>> &graph,
              std::vector<Qitem> &q,//使用vector实现队列，保存所有信息
              std::vector<int> &end_word_pos) {
    std::map<std::string, int> visit;//记录访问过的单词
    int min_step = 0;//到达endWord最少步数
    q.push_back(Qitem(beginWord.c_str(), -1, 1));//起始单词前驱是-1
    int front = 0;
    while (front != q.size()) {
        //队列头部元素
        std::string word = q[front].node;
        int step = q[front].step;
        //step > min_step时，代表所有到终点的路径都搜素完成
        if (min_step != 0 && min_step < step) break;
        if (word == endWord) {
            min_step = step;//当搜索到结果时，记录到达终点的最小步数
			end_word_pos.push_back(front);
        }
        const std::vector<std::string> &neighbors = graph[word];
        for (int i = 0; i < neighbors.size(); i++) {
            //节点没有被访问或者另一条最短路径
        	if (visit.find(neighbors[i]) == visit.end() || 
               visit[neighbors[i]] == step + 1) {
                q.push_back(Qitem(neighbors[i], front, step + 1));
                visit[neighbors[i]] = step + 1;
            }   
        }
        front++;
    }
}
class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
		std::map<std::string,std::vector<std::string>> graph;
        construct_graph(beginWord,wordList, graph);//构建邻接表
        
        std::vector<Qitem> q;//使用vector实现队列，保存所有信息
        std::vector<int> end_word_pos;
        bfs_graph(beginWord, endWord, graph, q, end_word_pos);
        
        std::vector<std::vector<std::string>> result;
        for (int i = 0; i < end_word_pos.size(); i++) {
            int pos = end_word_pos[i];
            std::vector<std::string> path;
            while (pos != -1) {
                path.push_back(q[pos].node);
                pos = q[pos].parent_pos;
            }
            result.push_back(std::vector<std::string>());
            for (int j = path.size() - 1; j >= 0; j--) {
                result[i].push_back(path[j]);
            }
        }
        return result;
    }
};
//双bfs
class Solution {
 public:
  vector<vector<string>> findLadders(string beginWord, string endWord,
                                     vector<string> wordList) {
    if (beginWord == endWord) return {{beginWord}};
    size_t wordLen = beginWord.size();
    unordered_set<string> wordDict(wordList.begin(), wordList.end());
    if (!wordDict.count(endWord)) return {};
    unordered_map<string, vector<string>> childMap;
    unordered_set<string> q1 = {beginWord};
    unordered_set<string> q2 = {endWord};
    bool found = false;
    bool reverse = false;
    while (!q1.empty() && !q2.empty() && !found) {
      // remove cur level node from wordDict
      if (q1.size() > q2.size()) {
        std::swap(q1, q2);
        reverse = !reverse;
      }
      for (auto& w : q1) wordDict.erase(w);
      // expand cur level node generate childMap
      unordered_set<string> qTmp;
      for (const auto& curWord : q1) {
        string newWord = curWord;
        for (size_t j = 0; j < wordLen; ++j) {
          char oldChar = curWord[j];
          for (char c = 'a'; c <= 'z'; ++c) {
            if (c == oldChar) continue;
            newWord[j] = c;
            if (wordDict.count(newWord)) {
              if (q2.count(newWord))
                found = true;  // in this case no need to expand
              else
                qTmp.insert(newWord);
              // update childMap
              if (!reverse)
                childMap[curWord].push_back(newWord);
              else
                childMap[newWord].push_back(curWord);
            }
          }
          newWord[j] = oldChar;
        }
      }  // expand done
      std::swap(q1, qTmp);
    }
    if (!found) return {};
    vector<string> cur = {beginWord};
    vector<vector<string>> res;
    dfs(endWord, cur, res, childMap);
    return res;
  }

  void dfs(const string& endWord, vector<string>& cur,
           vector<vector<string>>& res,
           const unordered_map<string, vector<string>>& childMap) {
    if (cur.back() == endWord) {
      res.push_back(cur);
      return;
    }
    string& curWord = cur.back();
    auto iter = childMap.find(curWord);
    if (iter == childMap.end()) {  // check if curWord has child
      return;
    }
    for (const auto& w : iter->second) {
      cur.push_back(w);
      dfs(endWord, cur, res, childMap);
      cur.pop_back();
    }
  }
};
```

#### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

```php
class Solution {

    /**
     * dfs
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid) {
        $count = 0;
        $n = count($grid);
        if ($n == 0) return $count;
        $m = count($grid[0]);
        for ($i = 0; $i < $n; $i++) {
            for ($j = 0; $j < $m; $j++) {
                if ($grid[$i][$j] == '1') {
                    $count++;
                    $this->dfs($grid, $i, $j, $n, $m);
                }
            }
        }
        return $count;
    }

    function dfs(&$grid, $i, $j, $n, $m) {
        if ($i < 0 || $j < 0 || $i >= $n || $j >= $m || $grid[$i][$j] == '0') return;
        $grid[$i][$j] = '0';
        $this->dfs($grid, $i + 1, $j, $n, $m);
        $this->dfs($grid, $i - 1, $j, $n, $m);
        $this->dfs($grid, $i, $j + 1, $n, $m);
        $this->dfs($grid, $i, $j - 1, $n, $m);
    }
}
```

#### [529. 扫雷游戏](https://leetcode-cn.com/problems/minesweeper/)

```php
class Solution {

    /**
     * dfs
     * @param String[][] $board
     * @param Integer[] $click
     * @return String[][]
     */
    function updateBoard($board, $click) {
        $n = count($board);
        $m = count($board[0]);
        $this->dfs($board, $click, $n, $m);
        return $board;
    }
    function dfs(&$board, $click, $n, $m) {
        [$row, $col] = $click;
        //判断是不是地雷
        if ($board[$row][$col] == 'M' || $board[$row][$col] == 'X') {
            $board[$row][$col] = 'X';
        } else {
            //不是地雷， 计算周围是地雷的个数
            $count = 0;
            foreach([-1, 0, 1] as $i) {
                foreach([-1, 0, 1] as $j) {
                    if ($i == 0 && $j == 0) continue;
                    $r = $row + $i;
                    $c = $col + $j;
                    if ($r < 0 || $c < 0 || $r >= $n || $c >= $m) continue;
                    if ($board[$r][$c] == 'M' || $board[$r][$c] == 'X') $count++;
                }
            }
            //有地雷，标注地雷的个数
            if ($count > 0) {
                $board[$row][$col] = (string)$count;
            } else {
                //没有地雷，标注为B
                $board[$row][$col] = 'B';
                foreach([-1, 0, 1] as $i) {
                    foreach([-1, 0, 1] as $j) {
                        if ($i == 0 && $j == 0) continue;
                        $r = $row + $i;
                        $c = $col + $j;
                        if ($r < 0 || $c < 0 || $r >= $n || $c >= $m) continue;
                        if ($board[$r][$c] == 'E') $this->dfs($board, [$r, $c], $n, $m);
                    }
                }
            }
        }
    }
    
    /**
     * bfs
     * @param String[][] $board
     * @param Integer[] $click
     * @return String[][]
     */
    function updateBoard($board, $click) {
        $n = count($board);
        $m = count($board[0]);
        $queue = [$click];
        while ($queue) {
            [$row, $col] = array_shift($queue);
            //地雷
            if ($board[$row][$col] == 'M' || $board[$row][$col] == 'X') {
                $board[$row][$col] = 'X';
            } else {
                //计算周围的地雷
                $count = 0;
                foreach([-1, 0, 1] as $i) {
                    foreach([-1, 0, 1] as $j) {
                        if ($i == 0 && $j == 0) continue;
                        $r = $row + $i;
                        $c = $col + $j;
                        if ($r < 0 || $c < 0 || $r >= $n || $c >= $m) continue;
                        if ($board[$r][$c] == 'M' || $board[$r][$c] == 'X') $count++;
                    }
                }
                //有地雷，标注地雷的个数
                if ($count > 0) {
                    $board[$row][$col] = (string)$count;
                } else {
                    //没有地雷，标注为B
                    $board[$row][$col] = 'B';
                    foreach([-1, 0, 1] as $i) {
                        foreach([-1, 0, 1] as $j) {
                            if ($i == 0 && $j == 0) continue;
                            $r = $row + $i;
                            $c = $col + $j;
                            if ($r < 0 || $c < 0 || $r >= $n || $c >= $m) continue;
                            if ($board[$r][$c] == 'E') {
                                $queue[] = [$r, $c];
                                $board[$r][$c] = 'B';
                            }
                        }
                    }
                }
            }
        }
        return $board;
    }
}
```

# 第4周 第10课 | 贪心算法

## 贪心的实现、特性及实战题目解

## 参考链接

#### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

```cpp
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
		std::vector<int> dp;
        //初始化dp数组
        for (int i = 0; i <= amount; i++) {
            dp.push_back(-1);
        }
        dp[0] = 0;//金额0最优解0
        for (int i = 1; i <= amount; i++) {
            //循环各个面值，找到dp[i]最优解
            for (int j = 0; j < coins.size(); j++) {
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        //递推公式
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
};
```

```php
class Solution {

    /**
     * 动态规划
     * @param Integer[] $coins
     * @param Integer $amount
     * @return Integer
     */
    function coinChange($coins, $amount) {
        $dp = array_fill(1, $amount, -1);
        $dp[0] = 0;
        sort($coins);
        for ($i = 1; $i <= $amount; $i++) {
            foreach ($coins as $coin) {
                if ($coin <= $i && $dp[$i - $coin] != -1) {
                    if ($dp[$i] == -1 || $dp[$i] > $dp[$i - $coin] + 1) {
                        $dp[$i] = $dp[$i - $coin] + 1;
                    }
                }
            }
        }
        return $dp[$amount];
    }
}
```

#### [动态规划定义](https://zh.wikipedia.org/wiki/动态规划)

## 课后作业



#### [860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/)

```python
def lemonadeChange(self, bills):
        five = ten = 0
        for i in bills:
            if i == 5: five += 1
            elif i == 10: five, ten = five - 1, ten + 1
            elif ten > 0: five, ten = five - 1, ten - 1
            else: five -= 3
            if five < 0: return False
        return True
```

```cpp
class Solution {

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills) {
        $map = [5=>0, 10=>0, 20=>0];
        foreach ($bills as $bill) {
            if ($bill > 5) {
                $sub = $bill - 5;
                foreach ([10 , 5] as $b) {
                    $count = intdiv($sub, $b);
                    if ($map[$b] >= $count) {
                        $sub %= $b; 
                        $map[$b] -= $count;
                    }
                }
                if ($sub > 0) return false; 
            }
            $map[$bill]++;
        }
        return true;
    }
}
```

#### [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

```php
class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $price = 0;
        for ($i = 1; $i < count($prices); $i++) {
            if ($prices[$i] > $prices[$i - 1]) {
                $price += $prices[$i] - $prices[$i - 1];
            }
        }
        return $price;
    }
}
```

#### [455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/)

```php
class Solution {

    /**
     * 贪心算法
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    function findContentChildren($g, $s) {
        sort($g);
        sort($s);
        for ($i = 0, $j = 0; $i < count($g) && $j < count($s); $j++) {
            if ($g[$i] <= $s[$j]) $i++;
        }
        return $i;
    }
}
```

#### [874. 模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/)

```php
class Solution {

    /**
     * @param Integer[] $commands
     * @param Integer[][] $obstacles
     * @return Integer
     */
    function robotSim($commands, $obstacles) {
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        $x = $y = $di = 0;
        $hash = [];
        $ans = 0;
        foreach ($obstacles as $obstacle) $hash[implode(',', $obstacle)] = true;
        foreach ($commands as $command) {
            if ($command == -2) {
                $di = ($di + 3) % 4;
            } else if ($command == -1) {
                $di = ($di + 1) % 4;
            } else {
                for ($k = 0; $k < $command; $k++) {
                    $nx = $x + $dx[$di];
                    $ny = $y + $dy[$di];
                    if (!$hash["{$nx},{$ny}"]) {
                        $x = $nx;
                        $y = $ny;
                        $ans = max($ans, $x * $x + $y * $y);
                    } 
                }
            }
        }
        return $ans;
    }
}
```

#### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

```php
class Solution {

    /**
     * 贪心
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums) {
 		if (!$nums) return false;
        $revCanJump = count($nums) - 1;
        for ($i = $revCanJump; $i >= 0; $i--) {
            if ($i + $nums[$i] >= $revCanJump) {
                $revCanJump = $i;
            }
        }
        return $revCanJump == 0;
    }
    
    function canJump($nums) {
        $max = 0;
        for ($i = 0; $i < count($nums); $i++) {
            if ($max < $i) return false;
            $max = max($max, $nums[$i] + $i);
        }
        return true;
    }
}
```

#### [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

```php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function jump($nums) {
        $len = count($nums);
        if ($len < 2) return 0;
        //当前可达到的最远位置和可达到的最远位置
        $current_max_index = $pre_max_index = $nums[0];
        $jump_min = 1;//最少跳跃次数
        for ($i = 1; $i < $len; $i++) {
            if ($i > $current_max_index) {
                $jump_min++;
                $current_max_index = $pre_max_index;
            }
            if ($pre_max_index < $nums[$i] + $i) {
                $pre_max_index = $nums[$i] + $i;
            }
        }
        return $jump_min;
    }
}
```

# 第4周 第11课 | 二分查找

## 二分查找的实现、特性及实战题目解析

## 参考链接

- [二分查找代码模板](https://shimo.im/docs/hjQqRQkGgwd9g36J)
- [Fast InvSqrt() 扩展阅读](https://www.beyond3d.com/content/articles/8/)

## 实战题目

#### [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)

```php
class Solution {

    /**
     * 方法一：二分法1
     * @param Integer $x
     * @return Integer
     */
    function mySqrt($x) {
        if ($x < 2) return $x;
        $left = 2;
        $right = intdiv($x, 2);
        while ($left <= $right) {
            $mid = $left + intdiv($right - $left, 2);
            $num = $mid * $mid;
            if ($num > $x) $right = $mid - 1;
            else if ($num < $x) $left = $mid + 1;
            else return $mid;
        }
        return $right;
    }
    /**
     * 方法一：二分法2
     * @param Integer $x
     * @return Integer
     */
    function mySqrt($x) {
       if ($x == 0) return 0;
        $start = 1; $end = $x;
        while ($start < $end) { 
            $mid = $start + intdiv($end - $start , 2);
            if ($mid <= intdiv($x, $mid) && ($mid + 1) > intdiv($x, $mid + 1))
                return $mid; 
            else if ($mid > intdiv($x, $mid))
                $end = $mid;
            else
                $start = $mid + 1;
        }
        return $start;
    }
    /**
     * 方法二：牛顿迭代法1
     * @param Integer $x
     * @return Integer
     */
    function mySqrt($x) {
        if ($x < 2) return $x;
        $curr = 1;
        do {
            $pre = $curr;
            $curr = ($curr + $x/ $x) /2;
        } while (abs($curr - $pre) > 1e-6);
        return (int) $curr;
    }
    /**
     * 方法二：牛顿迭代法2
     * @param Integer $x
     * @return Integer
     */
    function mySqrt($x) {
        if ($x == 0) return $x;
        $curr = $x;
      	while ($curr * $curr > $x)
            $curr = intdiv($curr + $x/$curr, 2);
        return (int) $curr;
    }
}
```

#### [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)

```php
class Solution {

    /**
     * 方法一：二分法
     * @param Integer $num
     * @return Boolean
     */
    function isPerfectSquare($num) {
        if ($num < 2) return true;
        $left = 1;
        $right = intdiv($num, 2);
        while ($left <= $right) {
            $mid = $left + intdiv($right - $left, 2);
            $n = $mid * $mid;
            if ($n > $num) $right = $mid - 1;
            else if ($n < $num) $left = $mid + 1;
            else return true;
        }
        return false;
    }
     /**
     * 方法二：牛顿迭代法1
     * @param Integer $num
     * @return Boolean
     */
    function isPerfectSquare($num) {
        if ($num < 2) return true;
        $curr = intdiv($num, 2);
        while ($curr * $curr > $num) {
            $curr = intdiv($curr + $num / $curr, 2);
        }
        return $curr * $curr == $num;
    }
    /**
     * 方法二：牛顿迭代法1
     * @param Integer $num
     * @return Boolean
     */
    function isPerfectSquare($num) {
        if ($num < 2) return true;
        $curr = $num >> 1;
        while ($curr * $curr > $num) {
            $curr = ($curr + $num / $curr) >> 1;
        }
        return $curr * $curr == $num;
    }
}
```

## 课后作业

#### [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

[牛逼位运算题解](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/)

```php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        $left = 0;
        $right = count($nums) - 1;
        while ($left < $right) {
            $mid = $left + intdiv($right - $left, 2);
            //(nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])
            if (($nums[0] > $target) ^ ($nums[0] > $nums[$mid]) ^ ($target > $nums[$mid])) {
                $left = $mid + 1;
            } else {
                $right = $mid;
            }
        }
        return $left == $right && $nums[$left] == $target ? $left: -1;
    }
    
    /**
     * 二分法（比较好理解）
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        $left = 0;
        $right = count($nums) - 1;
        while ($left <= $right) {
            $mid = $left + intdiv($right - $left, 2);
            if ($nums[$mid] == $target) return $mid;
            if ($nums[$left] <= $nums[$mid]) {//前半部分有序
                if ($nums[$left] <= $target && $target < $nums[$mid]) {
                    $right = $mid - 1;
                } else {
                    $left = $mid + 1;
                }
            } else {//后半部分有序
                if ($nums[$mid] < $target && $target <= $nums[$right]) {
                    $left = $mid + 1;
                } else {
                    $right = $mid - 1;
                }
            }
        }
        return -1;
    }
}
```

#### [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)

```php
class Solution {

    /**
     * 方法一：二分法
     * @param Integer[][] $matrix
     * @param Integer $target
     * @return Boolean
     */
    function searchMatrix($matrix, $target) {
        $n = count($matrix);
        $m = count($matrix[0]);
        $left = 0;
        $right = $n * $m - 1;
        while ($left <= $right) {
            //$mid = $left + floor(($right - $left) >> 2);
            $mid = ($left + $right) >> 1;
            $num = $matrix[intval($mid / $m)][$mid % $m];
            if ($num < $target) {
                $left = $mid + 1;
            } else if ($num > $target){
                $right = $mid - 1;
            } else return true;
        }
        return false;
    }
}
```

#### [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

[参考题解](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-3/)

```php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function findMin($nums) {
        $left = 0;
        $right = count($nums) - 1;
        if ($nums[0] < $nums[$right] || $left == $right) return $nums[0];
        while ($left < $right) {
            $mid = $left + intdiv($right - $left, 2);
            if ($nums[$mid] > $nums[$mid + 1]) return $nums[$mid + 1];
            if ($nums[$mid - 1] > $nums[$mid]) return $nums[$mid];
            if ($nums[0] < $nums[$mid]) {
                $left = $mid + 1;
            } else {
                $right = $mid - 1;
            }
        }
    }
}
```

```cpp
class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
         /* 左闭右闭区间，如果用右开区间则不方便判断右值 */ 
        int right = nums.size() - 1;
        /* 循环不变式，如果left == right，则循环结束 */
        while (left < right) {                      
            /* 地板除，mid更靠近left */
            int mid = left + (right - left) / 2;
            /* 中值 > 右值，最小值在右半边，收缩左边界 */ 
            if (nums[mid] > nums[right]) {
                 /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */ 
                left = mid + 1;         
                /* 明确中值 < 右值，最小值在左半边，收缩右边界 */ 
            } else if (nums[mid] < nums[right]) {
                 /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */ 
                right = mid;                       
            }
        }
        /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */
        return nums[left];    
    }
};
```