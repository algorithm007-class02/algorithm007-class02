学习笔记

<h1>第二周学习总结</h1>

<h2>知识点</h2>

<b>1.栈(stack),队列(queue),双端队列(deque)</b></p>
Stack:先进后出(FILO),插入删除都为O(1)</p>
Queue:先进先出(FIFO),插入删除都为O(1)</p>
Deque:两端都可以插入删除的Queue，插入删除都是O(1)</p>
</br>
<b>2.哈希表(Hash Table),映射(map),集合(set)</b></p>





</br>

<h2>作业</h2></p>
<b>1.LeetCode242 有效的字母异位词</b></p>
思路1：暴力法，将两个string转化为list并排序，比较两个list

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        list_1=list(s)
        list_2=list(t)
        list_2.sort()
        list_1.sort()
        if list_1==list_2:
            return True
        else:
            return False
```
</br>
思路2：set</p>

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        se = set(s)
        if se == set(t):
            for i in se:
                # 直接比较字符元素个数比较字符的个数
                if s.count(i) != t.count(i):return False
            return True
        else:
            return False
```

</br>
<b>2.LeetCode641 设计循环双端队列</b>
</br>
思路:使用collections

```python
class MyCircularDeque:

    def __init__(self, k: int):
        self.q = collections.deque(maxlen=k)

    def insertFront(self, value: int) -> bool:
        return len(self.q) < self.q.maxlen and (self.q.appendleft(value) or True)

    def insertLast(self, value: int) -> bool:
        return len(self.q) < self.q.maxlen and (self.q.append(value) or True)

    def deleteFront(self) -> bool:
        return self.q and (self.q.popleft() or True)
    
    def deleteLast(self) -> bool:
        return self.q and (self.q.pop() or True)
        
    def getFront(self) -> int:
        return not self.q and -1 or self.q[0]
    
    def getRear(self) -> int:
        return not self.q and -1 or self.q[-1]

    def isEmpty(self) -> bool:
        return not self.q

    def isFull(self) -> bool:
        return len(self.q) == self.q.maxlen

```
</br>
<b>LeetCode42 接雨水</b></p>
思路1：使用暴力解法，超时</p>

```python
class Solution:
    def trap(self, height: List[int]) -> int:
        ans = 0
        for i in range(len(height)):
            max_left, max_right = 0,0
            # 寻找 max_left
            for j in range(0,i):
                max_left = max(max_left,height[j])
            # 寻找 max_right
            for j in range(i,len(height)):
                max_right = max(max_right,height[j])
            if min(max_left,max_right) > height[i]:
                ans += min(max_left,max_right) - height[i]
        return ans
```

思路2：双指针法就是将上边的一个下标 i，变为两个下标 left，right，分别位于输入数组的两端。向中间移动时，边移动边计算。
```python
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height: return 0
        n = len(height)

        left,right = 0, n - 1  # 分别位于输入数组的两端
        maxleft,maxright = height[0],height[n - 1]
        ans = 0

        while left <= right:
            maxleft = max(height[left],maxleft)
            maxright = max(height[right],maxright)
            if maxleft < maxright:
                ans += maxleft - height[left]
                left += 1
            else:
                ans += maxright - height[right]
                right -= 1

        return ans
```

<b>LeetCode49 字母异位词分组</b>

```python
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        list_of_sorted_str = []
        list_of_anagrams = []
        for str in strs:
            list_of_sorted_str.append(''.join(sorted(str)))
        d = {}
        for key,value in enumerate(list_of_sorted_str):
            if value not in d:
                d[value]=[strs[key]]
            else:
                d[value].append(strs[key])
        for key in d:
            list_of_anagrams.append(d[key])
        return list_of_anagrams
```