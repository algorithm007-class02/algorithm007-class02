学习笔记



#### 二分查找

前提;

1. 目标函数单调性(有序)
2. 存在上下界
3. 能够通过索引访问

模板函数：

```python

left,right=0,len(array)-1
while left<=right:
    mid=(left+right)/2
    if array[mid] == target:
        #find the target
        break or return target
    elif array[mid] < target:
        left = mid+1
    else:
        right = mid-1

```
