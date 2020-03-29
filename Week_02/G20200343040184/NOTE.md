学习笔记
#  第2周 第4课 | 栈、队列、优先队列、双端队列

## 参考链接

- [Java 的 PriorityQueue 文档](http://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)
- [Java 的 Stack 源码](http://developer.classpath.org/doc/java/util/Stack-source.html)
- [Java 的 Queue 源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)
- [Python 的 heapq](http://docs.python.org/2/library/heapq.html)
- [高性能的 container 库](http://docs.python.org/2/library/collections.html)

## 预习题目

#### [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

```php
class Solution {

    /**
     * 方法一：栈(spl标准库)
     * @param String $s
     * @return Boolean
     */
    function isValid($s) {
        //构造哈希表
		$map = [')'=>'(', ']'=>'[', '}'=>'{'];
        $stack = new SplStack();
        for ($i = 0, $len = strlen($s); $i < $len; $i++) {
            if (!isset($map[$s[$i]])) {
                $stack->push($s[$i]);
            } else if (!$stack->count() || $stack->pop() != $map[$s[$i]]) {
                return false;
            }
        }
        return !$stack->count();
    }
    /**
     * 用数组模拟栈 (比spl标准库速度快)
     */
    function isValid1($s) {
        $map = [')'=>'(', ']'=>'[', '}'=>'{'];
        $stack = [];
        for ($i = 0, $len = strlen($s); $i < $len; $i++) {
            if (!isset($map[$s[$i]])) {
                $stack[] = $s[$i];
            } else if (empty($stack) || array_pop($stack) != $map[$s[$i]]) {
                return false;
            }
        }
        return empty($stack);
    }
    //方法二：暴力（字符串替换）
    function isValid2() {
        
    }
}
```

```python
class Solution(object):
    def isValid(self, s):
        mymap = {')':'(', ']':'[', '}':'{'}
        stack = []
        for c in s:
            if c not in mymap:
                stack.append(c)
            elif not stack or stack.pop() != mymap[c]:
                return False
        return not stack
```

#### [155. 最小栈](https://leetcode-cn.com/problems/min-stack/)

```cpp
class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {

    }
    
    void push(int x) {
        _data.push(x);
        if (_min.empty()) {
            _min.push(x);
        } else {
            if (_min.top() < x) {
                x = _min.top();
            }
            _min.push(x);
        }
    }
    
    void pop() {
        //数据栈和最小栈同时出栈
        _data.pop();
		_min.pop();
    }
    
    int top() {
		return _data.top();
    }
    
    int getMin() {
		return _min.top();
    }
private:
    std::stack<int> _data;
    std::stack<int> _min;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
```

## 实战题目

#### [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

```php
class Solution {
	/**
     * 方法一：暴力（算出两两柱子直接的面积）[执行超时]
     * 时间：O(n^3)
     * 空间：O(1)
     * @param Integer[] $heights
     * @return Integer
     */
    function largestRectangleArea($heights) {
        $maxarea = 0;
        for ($i = 0, $count = count($heights); $i < $count; $i++) {
            for ($j = $i; $j < $count; $j++) {
             	//找两个柱子之间的最小高度
                $min_height = $heights[$i];
                for ($k = $i + 1; $k <=$j; $k++) $min_height = min($min_height, $heights[$k]);
                $maxarea = max($maxarea, $min_height * ($j - $i + 1));
            }
        }
        return $maxarea;
    }
    /**
     * 方法二：优化的暴力（用一对柱子之间的最低高度，就当前柱子的最低高度）[执行超时]
     * 时间：O(n^2)
     * 空间：O(1)
     * @param Integer[] $heights
     * @return Integer
     */
    function largestRectangleArea($heights) {
        $maxarea = 0;
        for ($i = 0, $count = count($heights); $i < $count; $i++) {
            $min_height = $heights[$i];
            for ($j = $i; $j < $count; $j++) {
             	//求当前柱子的最低高度
                $min_height = min($min_height, $heights[$j]);
                //记录最大面积
                $maxarea = max($maxarea, $min_height * ($j - $i + 1));
            }
        }
        return $maxarea;
    }
    /**
     * 方法三：分治（递归）[执行超时]
     * 时间：O(nlongn)
     * 空间：O(n)
     * @param Integer[] $heights
     * @return Integer
     */
    function largestRectangleArea($heights) {
        return $this->maxArea($heights, 0, count($heights) - 1);
    }
    function maxArea($heights, $start, $end) {
        if ($start > $end) return 0;
        $min_index = $start;
        //计算区间最小高度
        for ($i = $start + 1; $i <= $end; $i++) {
            if ($heights[$min_index] > $heights[$i]) $min_index = $i; 
        }
        return max($heights[$min_index] * ($end - $start + 1), $this->maxArea($heights,$start, $min_index - 1), $this->maxArea($heights, $min_index + 1, $end));
    }
    
    //方法四：优化的分治（代码比较长）[放弃]
    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28941/segment-tree-solution-just-another-idea-onlogn-solution
    
    /**
     * 方法五：栈(最优解)
     * @param Integer[] $heights
     * @return Integer
     */
    function largestRectangleArea($heights) {
        $stack = [-1]; //数组模拟栈, 并初始化
        $maxarea = 0;
        $count = count($heights);
        for ($i = 0; $i < $count; $i++) {
            //如果比栈顶元素小，出栈计算面积，并更新面积最大值
            while (end($stack) != -1 && $heights[end($stack)] > $heights[$i]) {
				$maxarea = max($maxarea, $heights[array_pop($stack)] * ($i - end($stack) - 1));
            }
            $stack[] = $i;
        }
        while (end($stack) != -1) {
            $maxarea = max($maxarea, $heights[array_pop($stack)] * ($count - end($stack) - 1));
        }
        return $maxarea;
    }
    function largestRectangleArea($heights) {
        $stack = []; //数组模拟栈
        $heights[] = 0;
        $maxarea = 0;
        $count = count($heights);
        for ($i = 0; $i < $count; $i++) {
            //如果比栈顶元素小，出栈计算面积，并更新面积最大值
            while ($stack && $heights[end($stack)] > $heights[$i]) {
				$maxarea = max($maxarea, $heights[array_pop($stack)] * ($i - end($stack) - 1));
            }
            $stack[] = $i;
        }
        array_pop($heights);
        return $maxarea;
    }
}
```

#### [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

```php
class Solution {

    /**
     * 方法一：暴力（每次去k个数字中的最大值,共有n-k+1个窗口）
     * @param Integer[] $nums
     * @param Integer $k
     * @return Integer[]
     */
    function maxSlidingWindow($nums, $k) {
        $res = [];
        $n = count($nums);
        for($i = 0; $i < $n - $k + 1; $i++){
            //$max = max(array_slice($nums, $i, $k));
            $max = $nums[$i];
            for($j = $i + 1; $j < $i + $k; $j++){
                if($nums[$j] > $max){
                    $max = $nums[$j];
                }
            }
            $res[]= $max;
        }
        return $res;
    }
    //方法二：双端队列
    function maxSlidingWindow($nums, $k) {
        $res = [];
        $n = count($nums);
        $window = [];//数据模拟双端队列
        for ($i = 0; $i < $n; $i++) {
            if ($window && $window[0] <= $i - $k) {
                array_shift($window);
            }
            while ($window && $nums[end($window)] < $nums[$i]) {
                array_pop($window);
            }
            $window[] = $i;
            //i大于等于k-1
            if ($i >= $k - 1) $res[]= $nums[$window[0]];
        }
        return $res;
    }
    //方法三：动态规划
    function maxSlidingWindow($nums, $k) {
        $len = count($nums);
        //初始化
        $left = $right = [];
        $left[0] = $nums[0]; 
        $right[$len - 1] = $nums[$len - 1];
        for ($i = 1; $i < $len; $i++) {
            //计算left
            if ($i % $k == 0) $left[$i] = $nums[$i];
            else $left[$i] = max($left[$i - 1], $nums[$i]);
            //计算right
            $j = $len - $i - 1;
            if (($j + 1) % $k == 0) $right[$j] = $nums[$j];
            else $right[$j] = max($nums[$j], $right[$j + 1]); 
        }
        //计算结果
        $res = [];
        for ($i = 0; $i < $len - $k + 1; $i++) {
            $res[] = max($left[$i + $k -1], $right[$i]);
        }
        return $res;
    }
}
```

## 课后作业

#### 用 add first 或 add last 这套新的 API 改写 Deque 的代码

```java
Deque<String> deque = new LinkedList<String>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);
String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
    System.out.println(deque.removseFirst());
}
System.out.println(deque);
```

#### 分析 Queue 和 Priority Queue 的源码

#### [641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)

```php
class MyCircularDeque {
    private $front = 0;
    private $rear = 0;
    private $cap = 0;
    private $data = [];
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * @param Integer $k
     */
    function __construct($k) {
        $this->cap = $k + 1;
    }
  
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertFront($value) {
        if ($this->isFull()) return false;
        $this->front = ($this->front - 1 + $this->cap) % $this->cap;
        $this->data[$this->front] = $value;
        return true;
    }
  
    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertLast($value) {
        if ($this->isFull()) return false;
        $this->data[$this->rear] = $value;
        $this->rear = ($this->rear + 1) % $this->cap;
        return true;
    }
  
    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteFront() {
        if ($this->isEmpty()) return false;
        $this->front = ($this->front + 1) % $this->cap;
        return true;
    }
  
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteLast() {
        if ($this->isEmpty()) return false;
        $this->rear = ($this->rear - 1 + $this->cap) % $this->cap;
        return true;
    }
  
    /**
     * Get the front item from the deque.
     * @return Integer
     */
    function getFront() {
        if ($this->isEmpty()) return -1;
        return $this->data[$this->front];
    }
  
    /**
     * Get the last item from the deque.
     * @return Integer
     */
    function getRear() {
        if ($this->isEmpty()) return -1;
        return $this->data[($this->rear - 1 + $this->cap) % $this->cap];
    }
  
    /**
     * Checks whether the circular deque is empty or not.
     * @return Boolean
     */
    function isEmpty() {
        return $this->front == $this->rear;
    }
  
    /**
     * Checks whether the circular deque is full or not.
     * @return Boolean
     */
    function isFull() {
        return ($this->rear + 1 + $this->cap) % $this->cap == $this->front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * $obj = MyCircularDeque($k);
 * $ret_1 = $obj->insertFront($value);
 * $ret_2 = $obj->insertLast($value);
 * $ret_3 = $obj->deleteFront();
 * $ret_4 = $obj->deleteLast();
 * $ret_5 = $obj->getFront();
 * $ret_6 = $obj->getRear();
 * $ret_7 = $obj->isEmpty();
 * $ret_8 = $obj->isFull();
 */
```

#### [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

```cpp
class Solution {
public:
    int trap(vector<int>& height) {

    }
};
```

```php
class Solution {

    /**
     * 栈
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
		$ans = 0;
        $stack = [];
        for ($i = 0, $l = count($height); $i < $l; $i++) {
            //栈不为空，切栈顶元素小于当前值
            while ($stack && $height[end($stack)] < $height[$i]) {
                $top = $height[array_pop($stack)];
                if (!$stack) break;
                $width = $i - end($stack) - 1;
                $ans += $width * (min($height[$i], $height[end($stack)]) - $top);
            }
            $stack[] = $i;
        }
        return $ans;
    }
}
```

# 第2周 第5课 | 哈希表、映射、集合

## 参考链接

- [Java Set 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
- [Java Map 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)

## 课后作业

写一个关于 HashMap 的小总结

## 实战题目 / 课后作业

#### [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

```php
class Solution {

    /**
     * 方法一：暴力解法（排序）
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        //return count_chars($s,1) == count_chars($t,1); //精简写法
		$s = str_split($s);
        $t = str_split($t);
        sort($s);
        sort($t);
        return $s == $t;
    }
    /**
     * 方法二：哈希表（map）
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        //todo: 判断长度是否相同
		$s_map = $t_map = [];
        for ($i = 0; $i < strlen($s); $i++) {
            $s_map[$s[$i]] = isset($s_map[$s[$i]]) ? $s_map[$s[$i]] + 1 : 1;
        }
        for ($i = 0; $i < strlen($t); $i++) {
            $t_map[$t[$i]] = isset($t_map[$t[$i]]) ? $t_map[$t[$i]] + 1 : 1;
        }
        ksort($s_map);
        ksort($t_map);
        return $s_map == $t_map;
    }
}
```

```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
```



#### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

```php
class Solution {

    /**
     * 方法一：暴力（排序后作为键）
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $map = [];
		foreach ($strs as $str) {
            $tstr = str_split($str);
            sort($tstr);
            $key = implode("", $tstr);
            $map[$key][] = $str;
        }
        return array_values($map);
    }
    function groupAnagrams($strs) {
        $map = [];
		foreach ($strs as $str) {
            $t_map = [];
            for ($i = 0, $l = strlen($str); $i < $l; $i++) {
                if (!isset($t_map[$str[$i]])) $t_map[$str[$i]] = 0;
                $t_map[$str[$i]]++;
            }
            ksort($t_map);
            //$key = json_encode($t_map);
            $key = "";
            foreach($t_map as $k=>$v) {
                $key .= "{$k}:{$v}";
            }
            $map[$key][] = $str;
        }
        return array_values($map);
    }
    function groupAnagrams($strs) {
         $resArr = [];
        // 将 26 个字母映射为 素数，求积可得唯一 key，相当于一个无冲突的 hash function
        $prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103];
        foreach ($strs as $str) {
            $strlen = 1;
            for ($i = 0; $i < strlen($str); $i++) {
                $strlen *= $prime[ord($str[$i]) - 97];
            }   
            $resArr[$strlen][] = $str;
        }
        return array_values($resArr);
    }
}
```

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

## 参考链接

- [养成收藏精选代码的习惯（示例）](http://shimo.im/docs/R6g9WJV89QkHrDhr)





## 本周作业

### 简单：

- 用 add first 或 add last 这套新的 API 改写 Deque 的代码
- 分析 Queue 和 Priority Queue 的源码

说明：改写代码和分析源码这两项作业，同学们需要在第 2 周的学习总结中完成。如果不熟悉 Java 语言，这两项作业可选做。

- 写一个关于 HashMap 的小总结。

说明：对于不熟悉 Java 语言的同学，此项作业可选做。

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

### 中等：

#### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)



#### [641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)

### 困难：

#### [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

```php
class Solution {
    /**
     * 方法一：暴力
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
		$ans = 0;
        $len = count($height);
        for ($i = 1; $i < $len - 1; $i++) {
            $max_left = 0; $max_right = 0;
            //求左侧最大高度
            for ($j = $i; $j >= 0; $j--) {
                $max_left = max($max_left, $height[$j]);
            }
            //求右侧最大高度
            for ($j = $i; $j < $len; $j++) {
                $max_right = max($max_right, $height[$j]);
            }
            $ans += min($max_left, $max_right) - $height[$i];
        }
        return $ans;
    }
    /**
     * 方法 2：动态编程
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
		$ans = 0;
        $len = count($height);
        $left_max = $right_max = [];
        //计算左边最大值数组
        $left_max[0] = $height[0];
        for ($i = 1; $i < $len; $i++) {
            $left_max[$i] = max($height[$i], $left_max[$i - 1]);
        }
        $right_max[$len - 1] = $height[$len - 1];
        for ($i = $len - 2; $i >= 0; $i--) {
            $right_max[$i] = max($height[$i], $right_max[$i + 1]);
        }
        for ($i = 1; $i < $len - 1; $i++) {
            $ans += min($left_max[$i], $right_max[$i]) - $height[$i];
        }
        return $ans;
    }
     /**
     * 方法 3：栈
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
		$ans = 0;
        $len = count($height);
        $stack = [];
        for ($i = 0; $i < $len; $i++) {
            while ($stack && $height[$i] > $height[end($stack)]) {
                $top = array_pop($stack);
                if (empty($stack)) break; 
     			$w = $i - end($stack) -1;
                $h = min($height[end($stack)], $height[$i]) - $height[$top]
                $ans += $w * $h;
            }
            $stack[] = $i;
        }
        return $ans;
    }
     /**
     * 方法 4：双指针
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
		$ans = 0;
        $left = 0;
        $right = count($height) - 1;
        $left_max = $right_max = 0;
        while ($left < $right) {
            if ($height[$left] < $height[$right]) {
				$left_max <= $height[$left] ? $left_max = $height[$left] : $ans += $left_max - $height[$left];
                $left++;
            } else {
                $right_max <= $height[$right] ? $right_max = $height[$right] : $ans += $right_max - $height[$right];
                $right--;
            }
        }
        return $ans;
    }
}
```



## 下周预习

### 预习知识点：

- [二叉树基础（上）：什么样的二叉树适合用数组来存储？](http://time.geekbang.org/column/article/67856)
- [二叉树基础（下）：有了如此高效的散列表，为什么还需要二叉树？](http://time.geekbang.org/column/article/68334)
- [递归树：如何借助树来求解递归算法的时间复杂度？](http://time.geekbang.org/column/article/69388)
- [分治算法：谈一谈大规模计算框架 MapReduce 中的分治思想](http://time.geekbang.org/column/article/73503)
- [回溯算法：从电影《蝴蝶效应》中学习回溯算法的核心思想](http://time.geekbang.org/column/article/74287)

### 预习题目：

- [二叉树的中序遍历](http://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
- [爬楼梯](http://leetcode-cn.com/problems/climbing-stairs/)
- [括号生成](http://leetcode-cn.com/problems/generate-parentheses/)
- [Pow(x, n)](http://leetcode-cn.com/problems/powx-n/)
- [子集](http://leetcode-cn.com/problems/subsets/)