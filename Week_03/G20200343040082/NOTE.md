学习笔记

#### 二叉树

满二叉树；  
完全二叉树；  
二叉搜索树；  


#### 堆

可以迅速找到一堆树中的最大或最小值的数据结构；

常用实现方式： 完全二叉树(用数组存放元素)；


#### 递归：

递归模板：

```python

def recursion(level, param1, param2, ...):
    # recursion terminator
    # 终结条件
    if level > MAX_LEVEL:
        process_result
        return

    # process logic in current level
    # 当前逻辑
    process(level, data, ....)

    # drill down
    # 下一层
    self.recursion(level+1, p1, ...)

    # reverse the current level status if needed

```

1. 不要人肉递归
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维

#### 分治、回溯： 特殊的递归，找重复性

分治模板：

```python

def divide_conquer(problem, param1, param2, ...):
    # recursion terminator
    # 终止条件
    if problem is None:
        print_result
        return

    # prepara data
    #  处理当前逻辑
    data = prepara_data(problem)
    subproblems = split_problem(problem, data)

    # conquer subprobelms 
    # 下探
    subresult1 = self.divide_conquer(subprobelms[0], p1, ...)
    subresult2 = self.divide_conquer(subprobelms[1], p1, ...)
    subresult3 = self.divide_conquer(subprobelms[2], p1, ...)
    ...

    # process and generate the final result
    # 合并结果
    result = process_result(subresult1, subresult2, subresult3, ...)

    # revert the current level states

```

常见算法：

分支：快排，二分查找；

回溯：N 皇后；