学习笔记

#### 二叉树

满二叉树；  
完全二叉树；  
二叉搜索树；  


#### 堆

可以迅速找到一堆树中的最大或最小值的数据结构；

常用实现方式： 完全二叉树(用数组存放元素)；

```c++

template <class T>
void fr_heap<T>::push(const T &newElement) {
    
    if (heapSize == arrLength-1) { 
        // TODO: 扩容
    }
    
    // 0 位置不放数据
    int currentIndex = ++heapSize;
    // 从下往上走
    // currentIndex = 1 root node
    while (currentIndex != 1 && heap[currentIndex/2] < newElement) {
    // 它的父节点 < 它，交换
        heap[currentIndex] = heap[currentIndex/2];
        currentIndex /= 2;
    }
    heap[currentIndex] = newElement;
}

template <class T>
void fr_heap<T>::pop() {
    
    if (heapSize == 0) {
        // error
    }
    
    heap[1].~T(); // 推出top元素
    
    // 取最后一个元素
    // 往heap中插入，从上往下走
    T lastElement = heap[heapSize--];
    
    // 父节点编号 i
    // 左子节点是 2*i
    // 右子节点是 2*i+1
    
    // currentIndex - 父节点
    // child - 左子节点
    int currentIndex = 1, child = 2;
    while (child <= heapSize) {
        
        // 如果左子节点 < 右子节点，则取右子节点编号
        // 取左右最大的一个编号
        if (child < heapSize && heap[child] < heap[child + 1])
            child++;
        
        // 需要插入的元素大于左右节点，则它就是父节点
        if (lastElement >= heap[child])
            break;
        
        // 左右节点中最大的升为父节点
        heap[currentIndex] = heap[child];
        // 更新父节点指针
        currentIndex = child;
        // 更新左子节点
        child *= 2;
    }
    heap[currentIndex] = lastElement;
}

```


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