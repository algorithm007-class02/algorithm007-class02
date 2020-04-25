[TOC]
### 递归
我认为**递归**应该是本周的主题了，大部分题目通过递归的方式去实现的效果非常好。特别是树的前序，后序，中序遍历，如果只是记住了左，根，右的关系的话，在遍历的时候就很容易出错，最好的方法是把树的遍历的递归记下来
#### 递归模板
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
#### 树的遍历
##### 基础概念
* 前序（Pre-order）：根-左-右 
* 中序（In-order）：左-根-右
* 后序（Post-order）：左-右-根 
##### 递归实现
[二叉树的遍历-递归实现/Java](https://shimo.im/docs/vhdVqvjxcpvD36JW/ )

#### 二叉搜索树
##### 基础概念
二叉搜索树也称二叉搜索树、有序二叉树（Ordered Binary Tree）、 排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的 二叉树： 
1. **左子树**上所有结点的值均小于它的根结点的值；
2. **右子树**上所有结点的值均大于它的根结点的值；
#### 总结学习情况
每一周都有很多题目没有弄懂，或者是很多题目虽然当时懂了，但是过不了多久就会忘记。因此需要及时回顾。而本周的作业量突然暴涨，除了需要完成当周的作业，我们还要做到及时地回顾，很多人的时间可能都不允许拥有大把大把的时间来做这些题，因此，可以尽量利用零散的时间，在闲暇之余哪怕做不了题，打开LeetCode的App都尽量多看一些题解的代码，增加自己的熟练程度。算法学习不容易，做题目也很容易枯燥，时刻提醒自己要不断进步，就算走得慢，也总比后退强。
