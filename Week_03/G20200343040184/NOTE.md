学习笔记
# 第3周 第6课 | 树、二叉树、二叉搜索树

## **1. 树、二叉树、二叉搜索树的实现和特性**

### 参考链接

- [二叉搜索树 Demo](https://visualgo.net/zh/bst)

### 思考题

树的面试题解法一般都是递归，为什么？
说明：同学们可以将自己的思考写在课程下方的留言区一起讨论，也可以写在第 2 周的学习总结中。

## **2. 实战题目解析：二叉树的中序遍历**

### 参考链接

- [树的遍历 Demo](https://visualgo.net/zh/bst)

### 实战题目 / 课后作业

#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

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

    private $values = [];
    /** 
     * 方法一：递归
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal1($root) {
        $this->inorder($root);
        return $this->values;
    }
    function inorder($root) {
        if ($root) {
            $this->inorder($root->left);
            $this->values[] = $root->val;
            $this->inorder($root->right);
        }
    }
    /** 
     * 方法二：迭代
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal2($root) {
        $stack = $res = [];
        while ($root || $stack) {
            while ($root) {
                $stack[] = $root;
                $root = $root->left;
            }
            $root = array_pop($stack);
            $res[] = $root->val;
            $root = $root->right;
        }
        return $res;
    }
    /** 
     * 方法三：颜色标记法
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal3($root) {
        $white = 0; $gray = 1;
        $stack = [[$white, $root]];
        $res = [];
        while ($stack) {
            [$color, $node ] = array_pop($stack);
            if (!$node) continue;
            if ($color == $white) {
                $stack[] = [$white, $node->right];
                $stack[] = [$gray, $node];
                $stack[] = [$white, $node->left];
            } else {
                $res[] = $node->val;
            }
        }
        return $res;
    }
    /** 
     * 方法四：莫里斯遍历
     * Step 1: 将当前节点current初始化为根节点
	 * Step 2: While current不为空，
	 * 若current没有左子节点
     * 	a. 将current添加到输出
     * 	b. 进入右子树，亦即, current = current.right
	 * 否则
     * 	a. 在current的左子树中，令current成为最右侧节点的右子节点
     * 	b. 进入左子树，亦即，current = current.left
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal4($root) {
        $res = [];
        $curr = $root;
        while ($curr) {
            if ($curr->left == null) {
                $res[] = $curr->val;
                $curr = $curr->right;
            } else {
                //查找左子树，最右侧节点
                $pre = $curr->left;
                while ($pre->right) {
                    $pre = $pre->right;
                }
                $pre->right = $curr;
                $tmp = $curr;
                $curr = $curr->left;
                $tmp->left = null;
            }
        }
        return $res;
    }
}
```

#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

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

    private $values;
    /**
     * 方法一：递归
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal1($root) {
		$this->values = [];
        $this->preorder($root);
        return $this->values;
    }
    function preorder($root) {
        if ($root) {
            $this->values[] = $root->val;
            $this->preorder($root->left);
            $this->preorder($root->right);
        }  
    }
    /**
     * 方法二：迭代
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal2($root) {
        $res = [];
        if ($root == null) return $res; 
        $stack = [$root];
        while ($stack) {
            $root = array_pop($stack);
            if (!$root) continue;
            $res[] = $root->val;
            $stack[] = $root->right;
            $stack[] = $root->left;
        }
        return $res;
    }
    
    /**
     * 方法三：颜色标记法
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal2($root) {
        $res = [];
        if (!$root) return $res;
        $stack = [[false, $root]];
        while ($stack) {
            [$flag, $root] = array_pop($stack);
            if (!$root) continue;
            if ($flag) {
                $res[] = $root->val;
            } else {
                $stack[] = [false, $root->right];
                $stack[] = [false, $root->left];
                $stack[] = [true, $root];
            }
        }
        return $res;
    }
    
    /**
     * 方法四：莫里斯遍历
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal4($root) {
        $res = [];
        $node = $root;
        while ($node) {
            //没有左节点
            if ($node->left == null) {
                $res[] = $node->val;
                $node = $node->right;
            } else {
                $predecessor = $node->left;
                while ($predecessor->right && $predecessor->right != $node) {
                    $predecessor = $predecessor->right;
                }
                if ($predecessor->right == null) {
                 	$res[] = $node->val;
                    $predecessor->right = $node;
                    $node = $node->left;
                } else {
                    $predecessor->right = null;
                    $node = $node->right;
                }
            }
        }
        return $res;
    }
}
```

#### [590. N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)

```cpp
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    /**
     * 方法一：递归
     */
    vector<int> postorder(Node* root) {
        helper(root);
        return res;
    }
    //方法二：迭代
    vector<int> postorder2(Node* root) {
        vector<int> v;
        if(!root) return v;
        stack<Node*> s;
        s.push(root);
        while (!s.empty()) {
            Node* node = s.top();
            v.push_back(node->val);
            s.pop();
            for (int i = 0; i < node->children.size(); i++) {
                if (node->children[i]) {
                    s.push(node->children[i]);
                }
            }
        }
        reverse(v.begin(), v.end());
        return v;
    }
private:
    vector<int> res;
    void helper(Node* root) {
        if (root) {
            for (int i = 0; i < root->children.size(); i++) {
                helper(root->children[i]);
            }
            res.push_back(root->val);
        }
    }
};
```

#### [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

```cpp
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    //方法一：迭代
    vector<int> preorder(Node* root) {
        vector<int> v;
        if (!root) return v;
        stack<Node*> s;
        s.push(root);
        while (!s.empty()) {
            Node* node = s.top();
            v.push_back(node->val);
            s.pop();
            for (int i = node->children.size() - 1; i >= 0; i--) {
                if (node->children[i]) s.push(node->children[i]); 
            }
        }
        return v;
    }
    //方法二：递归
    vector<int> preorder2(Node* root) {
        vector<int> v;
        helper(root, v);
        return v;
    }
    void helper(Node * root, vector<int> &v) {
        if (root) {
            v.push_back(root->val);
            for (int i = 0; i < root->children.size(); i++) {
                helper(root->children[i], v);
            }
        }
    }
};
```

#### [429. N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

```cpp
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> v;
    //方法一：递归
    vector<vector<int>> levelOrder(Node* root) {
        if (!root) return v;
        helper(0, root);
        return v;
    }
    void helper(int l, Node* root) {
        if (v.size() <= l) v.push_back({vector<int>()});
        v[l].push_back(root->val);
        for (int i = 0; i < root->children.size(); i++) {
            if (root->children[i]) helper(l + 1, root->children[i]);
        }
    }
    //迭代
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (!root) return res;
        queue<Node*> q;
        q.push(root);
        while (!q.empty()) {
            int n = q.size();
            vector<int> tmp;
            while(n--) {
                Node * node = q.front();
                tmp.push_back(node->val);
                q.pop();
                for (int i = 0; i < node->children.size(); i++) {
                    if (node->children[i]) q.push(node->children[i]);
                }
            }
            res.push_back(tmp);
        }
        return res;
    }
};
```

# 第3周 第6课 | 堆和二叉堆、图

## **1. 堆和二叉堆的实现和特性**

### 参考链接

[维基百科：堆（Heap）](https://en.wikipedia.org/wiki/Heap_(data_structure))

## **2. 实战题目解析：最小的k个数、滑动窗口最大值等问题**

### 实战例题

#### [面试题40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

```php
class Solution {

    /**
     * 方法一：排序取前k个数
     * 方法二：使用大顶堆
     * 方法三：快排
     * @param Integer[] $arr
     * @param Integer $k
     * @return Integer[]
     */
    function getLeastNumbers($arr, $k) {
		$heap = new SplMaxHeap();
        foreach ($arr as $num) {
            if ($heap->count() < $k) {
                $heap->insert($num);
            } else if ($heap->current() > $num) {
                $heap->next();
                $heap->insert($num);
            }
        }
        $res = [];
        foreach ($heap as $num) {
            $res[] = $num;
        }
        return $res;
    }
}
```

#### [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a1, a2)->(a2 - a1));
        for (int i = 0; i < nums.length; i++) {
            int start = si - k;
            if (start >= 0) {
            	maxPQ.remove(nums[start]);   
            }
            maxPQ.offer(nums[i]);
            if (maxPQ.size() == k) {
                res[i - k + 1] = maxPQ.peek();
            }
        }
        return res;
    }
}
```

#### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

```cpp
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int,int>>> pq;
        unnordered_map<int, int> cnt;
        for (auto num: nums) cnt[num]++;
        for (auto kv: cnt) {
            pq.push({kv.second, kv.first});
            if (pq.size() > k) pq.pop();
        }
        vector<int> res;
        while (!pq.empty()) {
            res.push_back(pq.top().second);
            pq.pop();
        }
        return res;
    }
};
```

```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue((a, b)->(b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            maxHeap.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
```

### 课后作业

#### [HeapSort ：自学](https://www.geeksforgeeks.org/heap-sort/)

#### [面试题49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/) 和 [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/)

```php
class Ugly {
    public $nums = [];
    //小顶堆
    function __construct() {
        $minHp = new SplMinHeap();
        $minHp->insert(1);
        $hash = [1 => 0];//去重
        foreach(range(1, 1690) as $i) {
            $num = $minHp->current();
            $this->nums[] = $num;
            $minHp->next();
            foreach ([2, 3, 5] as $j) {
                $new = $num * $j;
                if (!isset($hash[$new])) {
                    $minHp->insert($new);
                    $hash[$new] = 0;
                }
            }
        } 
    }
}
class UglyDp {
    public $nums = [1];
    //动态规划
    function __construct() {
        $p2 = $p3 = $p5 = 0;
        for ($i = 1; $i < 1690; $i++) {
            $num = min($this->nums[$p2] * 2, $this->nums[$p3] * 3, $this->nums[$p5] * 5);
            $this->nums[] = $num;
            if ($num == $this->nums[$p2] * 2) $p2++; 
            if ($num == $this->nums[$p3] * 3) $p3++; 
            if ($num == $this->nums[$p5] * 5) $p5++; 
        }
    }
}
class Solution {
	private static $ugly;
    function __construct() {
        if (!self::$ugly) self::$ugly = new UglyDp();
    }
    /**
     * @param Integer $n
     * @return Integer
     */
    function nthUglyNumber($n) {
		return self::$ugly->nums[$n - 1];
    }
}
```

#### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

```cpp
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int,int>>> pq;
        unordered_map<int, int> cnt;
        for (auto num: nums) cnt[num]++;
        for (auto kv: cnt) {
            pq.push({kv.second, kv.first});
            if (pq.size() > k) pq.pop();
        }
        vector<int> res;
        while (!pq.empty()) {
            res.push_back(pq.top().second);
            pq.pop();
        }
        return res;
    }
};
```

```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b)->(b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            maxHeap.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
```

## **3. 图的实现和特性**

### 思考题

- 自己画一下有向有权图

### 参考链接

#### 连通图个数：[200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

```php
class Solution {

    /** 
     * 深度优先遍历
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid) {
		$nr = count($grid);
        if (!$grid || $nr == 0) return 0; 
        $nc = count($grid[0]);
        $num = 0;
        for ($i = 0; $i < $nr; $i++) {
         	for ($j = 0; $j < $nc; $j++) {
                if ($grid[$i][$j] == '1') {
                    $this->dfs($grid, $i, $j);
                    $num++;
                }
            }   
        }
        return $num;
    }
    //深度优先搜索
    function dfs(&$grid, $i, $j) {
        $nr = count($grid);
        $nc = count($grid[0]);
        // if ($i < 0 || $j < 0 || $i >= $nr || $j >= $nc || $grid[$i][$j] != '1') {
        //     return;
        // }
        $grid[$i][$j] = '0';
        $dx = [-1, 1 ,0, 0];
        $dy = [0, 0, -1, 1];
        foreach (range(0, 3) as $k) {
            $x = $i + $dx[$k];
            $y = $j + $dy[$k];
            if ($x >= 0 && $x < $nr && $y >= 0 && $y < $nc && $grid[$x][$y] == '1') {
                    $this->dfs($grid, $x, $y);
            } 
        }
        return 1;
    }
    //广度优先搜索
    function bfs(&$grid, $i, $j) {
        $nr = count($grid);
        $nc = count($grid[0]);
        $queue = [];
        $queue[] = [$i, $j];
        $grid[$i][$j] = '0';
        $dx = [-1, 1 ,0, 0];
        $dy = [0, 0, -1, 1];
        while ($queue) {
            [$r, $c] = array_pop($queue);
            foreach (range(0, 3) as $k) {
                $x = $r + $dx[$k];
                $y = $c + $dy[$k];
                if ($x >= 0 && $x < $nr && $y >= 0 && $y < $nc && $grid[$x][$y] == '1') {
                    $queue[] = [$x, $y];
                    $grid[$x][$y] = '0';
                } 
            }
        }
    }
    //并查集
}
```

#### 拓扑排序（Topological Sorting）：

[ https://zhuanlan.zhihu.com/p/34871092](https://zhuanlan.zhihu.com/p/34871092)

#### 最短路径（Shortest Path）：Dijkstra 

https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158

#### 最小生成树（Minimum Spanning Tree）：

[https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051](https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051)

# 第3周 第7课 | 泛型递归、树的递归

## **1. 递归的实现、特性以及思维要点**

### 参考链接

- [递归代码模板](http://shimo.im/docs/DjqqGCT3xqDYwPyY)

```python
def recursion(level, param1, param2, ...): 
    # recursion terminator 递归终止条件
    if level > MAX_LEVEL: 
	   process_result 
	   return 

    # process logic in current level 处理当前层逻辑
    process(level, data...) 

    # drill down 下探到下一层
    self.recursion(level + 1, p1, ...) 

    # reverse the current level status if needed 清理当前层
```

```java
public void recur(int level, int param) { 

  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic 
  process(level, param); 

  // drill down 
  recur( level: level + 1, newParam); 

  // restore current status 
 
}
```

1、不要人肉递归（最大误区）

2、找到最近最简单方法，将其拆机为可重复解决的子问题（重复子问题）

3、数学归纳法思维

## 2. 实战题目解析：爬楼梯、括号生成等问题**

### 实战题目

#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

```php
class Solution {

    private $map = [];
    /**
     * 递归写法
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n) {
        if ($n <= 2) return $n;
        if (!isset($this->map[$n])) {
            $this->map[$n] = $this->climbStairs($n - 1) + $this->climbStairs($n - 2);
        }
        return $this->map[$n];
    }
}
```

#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

```php
class Solution {

    private $result;
    /**
     * @param Integer $n
     * @return String[]
     */
    function generateParenthesis($n) {
        $this->result = [];
        $this->generate(0, 0, $n "");
        return $this->result;
    }
    function generate($left, $right, $n, $s) {
        //递归终止条件
        if ($left == $n && $right == $n) {
            $this->result[] = $s;
            return;
        }
        //处理当前层逻辑
        //下探到下一层
        if ($left < $n) $this->generate($left + 1, $right, $n, $s."(");
        if ($right < $left) $this->generate($left, $right + 1, $n, $s.")");
        //清理当前层
    }
}
```

#### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

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
     * 递归
     * @param TreeNode $root
     * @return TreeNode
     */
    function invertTree1($root) {
        if (!$root) {
            return $root;
        }
        $left = $root->left;
        $root->left = $this->invertTree($root->right);
        $root->right = $this->invertTree($left);
        return $root;
    }
    //迭代（使用spl库速度更快）
    function invertTree2($root) {
        if (!$root) {
            return $root;
        }
        $queue = [$root];
        while ($queue) {
            $current = array_pop($queue);
            $left = $current->left;
            $current->left = $current->right;
            $current->right = $left;
            if ($current->left) $queue[] = $current->left;
            if ($current->right) $queue[] = $current->right;
        }
        return $root;
    }
}
```

#### [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

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
     * 递归、迭代、中序遍历
     * @param TreeNode $root
     * @return Boolean
     */
     function isValidBST($root) {
        return $this->isValid($root);
     }
     function isValid($root, $min = null, $max = null) {
        if (!$root) return true;
        if (!$root) return true;
        if ($min !== null && $root->val <= $min) return false;//不能比最小值还小
        if ($max !== null && $root->val >= $max) return false; //不能比最大值还大
        //左子树更新最大值，右子树更新最小是
        return $this->isValid($root->left, $min, $root->val) && $this->isValid($root->right, $root->val, $max);
        return $this->isValid($root->left, $min, $root->val) && $this->isValid($root->right, $root->val, $max);
     }
}
```

#### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

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
     * 方法一：递归
     * 方法二：迭代（使用栈）
     * @param TreeNode $root
     * @return Integer
     */
    function maxDepth($root) {
        if (!$root) return 0; 
    	return max($this->maxDepth($root->left), $this->maxDepth($root->right)) + 1;
    }
}
```

#### [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

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
     * 递归
     * @param TreeNode $root
     * @return Integer
     */
    function minDepth($root) {
        if (!$root) return 0;
        if ($root->left === null && $root->right === null) return 1; 
        $left_depth = $this->minDepth($root->left);
        $right_depth = $this->minDepth($root->right);
        //左右子树有一个为空
        if ($left_depth == 0 || $right_depth ==0) return $left_depth + $right_depth + 1; 
        return min($left_depth, $right_depth) + 1;
    }
}
```

#### [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)

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

class Codec {
    function __construct() {
        
    }
  
    /**
     * @param TreeNode $root
     * @return String
     */
    function serialize($root) {
        $this->encode($root, $vals);
        return implode(',', $vals);
    }
    
    function encode ($node, &$vals = null) {
        if (!$vals) $vals = [];
        if ($node) {
            $vals[] = $node->val;
            $this->encode($node->left, $vals);
            $this->encode($node->right,$vals);
        } else {
            $vals[] = "null";
        }
    }
  
    /**
     * @param String $data
     * @return TreeNode
     */
    function deserialize($data) {
        $vals = explode(',', $data);
        return $this->decode($vals);
    }
    
    function decode(&$vals) {
        $val = array_shift($vals);
        if ($val == "null") {
            return null;
        } else {
            $node = new TreeNode($val);
            $node->left = $this->decode($vals);
            $node->right = $this->decode($vals);
        }
        return $node;
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * $obj = Codec();
 * $data = $obj->serialize($root);
 * $ans = $obj->deserialize($data);
 */
```

```php
class Codec {
    function __construct() {
        
    }
  
    /**
     * @param TreeNode $root
     * @return String
     */
    function serialize($root) {
        if (!$root) return "[]";
       	$res = [];
        $res = [$root->val];
        $queue = new SplQueue();
        $queue->push($root);
        while ($queue->count()) {
            $node =  $queue->shift();
            if ($node->left !== null) {
                $res[] = $node->left->val;
                $queue->push($node->left);
            } else {
                $res[] = 'null';
            }
            if ($node->right !== null) {
                $res[] = $node->right->val;
                $queue->push($node->right);
            } else {
                $res[] = 'null';
            }
        }
        //return '[' . trim(implode(',', $res), ',null') . ']';
        return '[' . implode(',', $res) . ']';
    }
  
    /**
     * @param String $data
     * @return TreeNode
     */
    function deserialize($data) {
        $vals = substr($data, 1, strlen($data) - 2);
        if (!$vals) return null;
        $vals = explode(',', $vals);
        $root = new TreeNode(array_shift($vals));
        $queue = new SplQueue();
        $queue->push($root);
        while ($vals) {
            $parent = $queue->shift();
            $left = array_shift($vals);
            if ($left != 'null') {
                $curr = new TreeNode($left);
                $parent->left = $curr;
                $queue->push($curr);
            }
            $right = array_shift($vals);
            if ($right != 'null') {
                $curr = new TreeNode($right);
                $parent->right = $curr;
                $queue->push($curr);
            }
        }
        return $root;
    }
}
```

### 每日一课

- [如何优雅地计算斐波那契数列](https://time.geekbang.org/dailylesson/detail/100028406)

### 课后作业

#### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

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
     * 递归
     * @param TreeNode $root
     * @param TreeNode $p
     * @param TreeNode $q
     * @return TreeNode
     */
    function lowestCommonAncestor($root, $p, $q) {
        if ($root == null || $root == $p || $root == $q) return $root;
        $left = $this->lowestCommonAncestor($root->left, $p, $q);
        $right = $this->lowestCommonAncestor($root->right, $p, $q);
        if (!$left) {
            return $right;
        } else if (!$right){
            return $left;
        } else {
            return $root;
        }
    }
}
```

#### [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

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
     * 递归
     * @param Integer[] $preorder
     * @param Integer[] $inorder
     * @return TreeNode
     */
    function buildTree1($preorder, $inorder) {
        if (count($preorder) == 0) return null;
        $root = new TreeNode($preorder[0]);
        $mid = array_search($preorder[0], $inorder);//根节点
        $root->left = $this->buildTree(array_slice($preorder,1, $mid), array_slice($inorder, 0, $mid + 1));//左子树
        $root->right = $this->buildTree(array_slice($preorder, $mid + 1), array_slice($inorder, $mid + 1));//右子树
        return $root;
    }
    
    //参数优化的递归
    private $preorder;// 前序参数索引
    private $inorder;// 中序参数索引
    private $preindex;
    private $pmap;//反转中序数组中所有键以及它们关联的值
    function buildTree1($preorder, $inorder) {
        $this->preorder = $preorder;
        $this->inorder = $inorder;
        $this->pmap = array_flip($inorder);
        $this->preindex = 0;
        return $this->helper($this->preindex, count($inorder) - 1);
    }
    function helper($instart, $inend) {
        if ($instart > $inend) return null;
        $val = $this->preorder[$this->preindex++];
        $index = $this->pmap[$val];
        
        $node = new TreeNode($val);
        $node->left = $this->helper($instart, $index - 1);
        $node->right = $this->helper($index + 1, $inend);
        return $node;
    }
}
```

#### [77. 组合](https://leetcode-cn.com/problems/combinations/)

```php
class Solution {
	private $output = [];
    private $n;
    private $k;
    /**
     * @param Integer $n
     * @param Integer $k
     * @return Integer[][]
     */
    function combine($n, $k) {
        $this->n = $n;
        $this->k = $k;
        $this->backtrack();
        return $this->output;
    }
    function backtrack($first = 1, $curr = []) {
        if (count($curr) == $this->k) {
            $this->output[] = $curr;
            return;
        } 
        // 此时剩余可选数字个数 $n - $i + 1
        // 所需数字个数 $k - count($list)
        //for ($i = $first; $i <= $this->n; $i++) {
        for ($i = $first; $this->n - $i + 1 >= $this->k - count($curr); $i++) {
            $curr[] = $i;
            $this->backtrack($i + 1, $curr);
            array_pop($curr);
        }
    }
}
```

#### [46. 全排列](https://leetcode-cn.com/problems/permutations/)

```php
class Solution {
	private $output = [];
    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute($nums) {
        $n = count($nums);
        $this->backtrack($nums, $n, 0);
        return $this->output;
    }
    function backtrack($nums, $n, $level) {
        if ($level == $n) {
            $this->output[] = $nums;
            return;
        }
        for ($i = $level; $i < $n; $i++) {
            //swap
            $this->swap($nums,$i, $level);
            $this->backtrack($nums, $n, $level + 1);
            //backtrack
            $this->swap($nums, $level, $i);
        }
    }
    function swap(&$nums, $i, $j) {
        $tmp = $nums[$i];
        $nums[$i] = $nums[$j];
        $nums[$j] = $tmp;
    }
}
```

#### [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

```php
class Solution {
	private $output = [];
    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permuteUnique($nums) {
        $len = count($nums);
        if ($len == 0) return [];
        sort($nums);
        $this->backtrack($nums, $len, 0);
        return $this->output;
    }
    function backtrack($nums, $len, $level, $used = [], $path = []) {
        if ($level == $len) {
            $this->output[] = $path;
            return;
        }
        for ($i = $level; $i < $len; $i++) {
            if ($used[$i]) continue;
            if ($i > 0 && $nums[i] == $nums[$i - 1] && !$used[$i]) continue;
            $path[] = $nums[$i];
            $used[$i] = true;
           
            $this->backtrack($nums, $len, $level + 1, $used, $path);
            $used[$i] = false;
            array_pop($path);
        }
    }
}
```

```php
class Solution {

    private $res = [];
    private $visited = [];
    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permuteUnique($nums) {
        sort($nums);
        $this->backtrack([], $nums);
        return $this->res;
    }
    function do($array, $nums) {
        if (count($array) == count($nums)) {
            array_push($this->res, $array);
            return;
        }

        for ($i = 0; $i < count($nums); $i++) {
            if (isset($this->visited[$i]) && $this->visited[$i] == 1) continue;
            if ($i > 0 && $nums[$i] == $nums[$i - 1] && $this->visited[$i - 1] == 0) continue;

            $this->visited[$i] = 1;
            array_push($array, $nums[$i]);
            $this->do($array, $nums);
            array_pop($array);
            $this->visited[$i] = 0;
        }
    }
    function backtrack($array, $nums) {
        if (count($array) == count($nums)) {
            $this->res[] = $array;
            return;
        }
        for ($i = 0; $i < count($nums); $i++) {
            if (isset($this->visited[$i]) && $this->visited[$i] == 1) continue;
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !visited[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if ($i > 0 && $nums[$i] == $nums[$i - 1] && $this->visited[$i - 1] == 0) continue;

            $this->visited[$i] = 1;
            $array[] = $nums[$i];
            $this->backtrack($array, $nums);
            array_pop($array);
            $this->visited[$i] = 0;
        }
    }
}
```

# 第3周 第8课 | 分治、回溯

## **1. 分治、回溯的实现和特性**

### 参考链接

- [分治代码模板](https://shimo.im/docs/3xvghYh3JJPKwdvt)

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

```php

```

## **2. 实战题目解析：Pow(x,n)、子集**

### 预习题目

#### [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)

```php
class Solution {

    /**
     * @param Float $x
     * @param Integer $n
     * @return Float
     */
    function myPow($x, $n) {
        if ($n < 0) {
            $n = -$n;
            $x = 1/$x;
        }
        return $this->pow($x, $n);
    }
    function pow ($x, $n) {
        if ($n == 0) return 1; 
        $p = $this->pow($x, $n/2);
        return $n & 1 ? $p * $p *$x : $p * $p;
    }
}
```

#### [78. 子集](https://leetcode-cn.com/problems/subsets/)

```php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function subsets($nums) {
        $res = [];
        $this->dfs($res, $nums, [], 0);
        return $res;
    }
    function dfs(&$res, $nums, $path, $index) {
        if ($index == count($nums)) {
            $res[] = $path;
            return;
        }
        $this->dfs($res, $nums, $path, $index + 1);
        $path[] = $nums[$index];
        $this->dfs($res, $nums, $path, $index + 1);
    }
}
```

```python
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = [[]]
        for i in nums:
            res = res + [[i] + num for num in res]
        return res
```

### 参考链接

- [牛顿迭代法原理](http://www.matrix67.com/blog/archives/361)
- [牛顿迭代法代码](http://www.voidcn.com/article/p-eudisdmk-zm.html)

## **3. 实战题目解析：电话号码的字母组合、N皇后**

### 实战题目

#### [169. 多数元素](https://leetcode-cn.com/problems/majority-element/)（简单、但是高频）

```php

```

#### [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

```php
class Solution {

    /**
     * @param String $digits
     * @return String[]
     */
    function letterCombinations($digits) {
        $map = [
            2 => 'abc',
            3 => 'def',
            4 => 'ghi',
            5 => 'jkl',
            6 => 'mno',
            7 => 'pqrs',
            8 => 'tuv',
            9 => 'wxyz',
        ]；
        $res = [];
        $this->search("", $digits, 0,$res, $map);
        return $res;
    }
    function search($s, $digits, $i, &$res, $map) {
        if ($i == strlen($digits)) {
            $res[] = $s;
            return;
        }
        $letters = $map[$digits[$i]];
        for ($j = 0, $len = strlen($letters); $j < $len; $j++) {
            $this->search($s.$letters[$j], $digits, $i + 1, $res, $map);
        }
    }
}
```

#### [51. N皇后](https://leetcode-cn.com/problems/n-queens/)

```php
class Solution {

    /**
     * @param Integer $n
     * @return String[][]
     */
    function solveNQueens($n) {
        $this->dfs($n, 0, []);
        return $this->res;
    }
    function dfs($n, $row, $cur_state) {
        if ($row == $n) {
            $output = [];
            foreach ($cur_state as $row=>$col) {
                $output[] = str_pad('', $col, '.').'Q'.str_pad('', $n - $col - 1, '.'); 
            }
            $this->res[] = $output;
            return;
        }
        for ($col = 0; $col < $n; $col++) {
            if ($this->col[$col] || $this->pie[$row + $col] 
            || $this->na[$row - $col]) continue;
            $this->col[$col] = true;
            $this->pie[$row + $col] = true;
            $this->na[$row - $col] = true;
            $cur_state[] = $col;
            $this->dfs($n, $row + 1, $cur_state);
            array_pop($cur_state);
            $this->col[$col] = false;
            $this->pie[$row + $col] = false;
            $this->na[$row - $col] = false;
        }
    }
}
```

# 本周作业

### 简单

- https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
- https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/

### 中等

- https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
- https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
- https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
- https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
- https://leetcode-cn.com/problems/combinations/
- https://leetcode-cn.com/problems/permutations/
- https://leetcode-cn.com/problems/permutations-ii/

# 总结

#### [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

回溯法【时间复杂度：?，空间复杂度：?】

#### [46. 全排列](https://leetcode-cn.com/problems/permutations/)

回溯法【时间复杂度：?，空间复杂度：O(n!)】

#### [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

回溯法【时间复杂度：O(NxN!)，空间复杂度：O(NxN!)】[题解](https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/)

#### [51. N皇后](https://leetcode-cn.com/problems/n-queens/)

回溯法【时间复杂度：O(n!)，空间复杂度：O(n)】

#### [77. 组合](https://leetcode-cn.com/problems/combinations/)

回溯法

#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

方法一：递归【时间复杂度：O(n)，空间复杂度：O(n)】

方法二：迭代【时间复杂度：O(n)，空间复杂度：O(n)】

方法三：迭代（栈）【时间复杂度：O(n)，空间复杂度：O(n)】

方法四：莫里斯遍历【时间复杂度：O(n)，空间复杂度：O(n)】

#### [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

递归【时间复杂度：O(n)，空间复杂度：O(n)】

#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

方法一：递归【时间复杂度：O(n)，空间复杂度：O(n)】

方法二：迭代【时间复杂度：O(n)，空间复杂度：O(n)】

方法三：迭代（栈）【时间复杂度：O(n)，空间复杂度：O(n)】

方法四：莫里斯遍历【时间复杂度：O(n)，空间复杂度：O(n)】

#### [169. 多数元素](https://leetcode-cn.com/problems/majority-element/)

方法一：排序法【时间复杂度：O(nlogn)，空间复杂度：O(1)】

方法二：哈希表计数法【时间复杂度：O(n)，空间复杂度：O(n)】

方法三：分治法【时间复杂度：*O*(*n*log*n*)，空间复杂度：*O*(log*n*)】

方法四：摩尔投票【时间复杂度：O(n)，空间复杂度：O(1)】

方法五：随机选取法【时间复杂度：O(n)，空间复杂度：O(1)】

#### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

方法一：递归 【时间复杂度：O(n)，空间复杂度：O(n)】

方法二：使用父指针迭代 【时间复杂度：O(n)，空间复杂度：O(n)】

方法三：无父指针的迭代 【时间复杂度：O(n)，空间复杂度：O(n)】

#### [面试题49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/) 和 [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/)

方法一：大顶堆

方法二：动态规划

#### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

方法一：小顶堆 【时间复杂度：O(nlogk)，空间复杂度：O(n)】

方法二：优先级队列 【时间复杂度：O(nlogk)，空间复杂度：O(n)】？

方法三：排序 【时间复杂度：O(nlogn)，空间复杂度：O(n)】

方法四：桶排序法 【时间复杂度：O(n)，空间复杂度：O(n)】

#### [429. N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

方法一：bfs【时间复杂度：O(n)，空间复杂度：O(n)】

方法二：dfs【时间复杂度：O(n)，空间复杂度：O(n)】

#### [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

方法一：递归【时间复杂度：O(n)，空间复杂度：O(n)】

方法二：迭代【时间复杂度：O(n)，空间复杂度：O(n)】

#### [590. N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)

方法一：递归【时间复杂度：O(n)，空间复杂度：O(n)】

方法二：迭代【时间复杂度：O(n)，空间复杂度：O(n)】



# 下周预习

## 预习知识点

- [深度和广度优先搜索：如何找出社交网络中的三度好友关系？](http://time.geekbang.org/column/article/70891)
- [贪心算法：如何用贪心算法实现 Huffman 压缩编码？](http://time.geekbang.org/column/article/73188)
- [二分查找（上）：如何用最省内存的方式实现快速查找功能？](http://time.geekbang.org/column/article/42520)
- [二分查找（下）：如何快速定位 IP 对应的省份地址？](http://time.geekbang.org/column/article/42733)

## 预习题目

- [二叉树的层次遍历](http://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description)
- [分发饼干](http://leetcode-cn.com/problems/assign-cookies/description/)
- [买卖股票的最佳时机 II](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)
- [跳跃游戏](http://leetcode-cn.com/problems/jump-game/)
- [x 的平方根](http://leetcode-cn.com/problems/sqrtx/)
- [有效的完全平方数](http://leetcode-cn.com/problems/valid-perfect-square/)

