## 第四周算法学习总结

### 深度优先， DFS
前中后序遍历二叉树,用递归实现,因为遍历时有回溯
#### 典型题目
1. 岛屿问题
2. 八皇后问题

### 广度优先， BFS
层级遍历n叉树,一般会借用一个队列实现,利用队列的先进先出属性,逐一放入上层节点,取出时再将其子节点放入队列,这样往复存取的过程中即可实现层级遍历.
#### 典型题目
1. 最短路径问题。
2. 单词接龙

### 贪心算法
很多时候贪心不是最优解，难点在于证明贪心是不是最好解决方案，因为其只拿到了当前最优解，比如按摩师的题，用贪心肯定是不对的，可以认为是动态规划的一个子集
#### 典型题目
1. 分饼干问题
2. 跳跃游戏

### 二分查找
老生常谈，变种非常多, 边界判断也是极为头疼, 主要还是要把模板写熟练,向左向右找时不用再思考,遇到特殊场景时,先列出判断条件,再依据条件写代码.
#### 典型题目
1. 求旋转数组后的各种查找问题
2. 平方根问题

### 已做完题目
https://www.jianshu.com/p/ddcf26614e96
https://www.jianshu.com/p/d29143b63095
https://www.jianshu.com/p/5b43ca01af37
https://www.jianshu.com/p/4ff08f8364e7
https://www.jianshu.com/p/ec25798ec968
https://www.jianshu.com/p/dc1a7b2d0512
https://www.jianshu.com/p/49571ae576f8
https://www.jianshu.com/p/209891513112

### 未做完题目,(先马后做,实在做不完了)
https://leetcode-cn.com/problems/jump-game-ii/
https://leetcode-cn.com/problems/search-a-2d-matrix/
https://leetcode-cn.com/problems/walking-robot-simulation/description/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
https://leetcode-cn.com/problems/minesweeper/description/
