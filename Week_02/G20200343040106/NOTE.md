# Week02题目总结

## LeetCode-84 柱状图中最大的矩形
### 一，暴力
这道题看到之后，暴力求解的思路是显而易见的，于是乎，不费力的写出了如下的代码：
```
//
// 最直观的想法：暴力搜索，[i,j]能构成的矩形面积为 S = minValue(i,j)*(j-i+1);
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int ans = 0;
        int curMin = 0;
        for(int i=0;i<heights.size();i++){
            curMin = heights[i];
            for(int j=i;j<heights.size();j++){
                if(heights[j]<=curMin){
                    curMin = heights[j];
                }
                ans = max(ans,curMin*(j-i+1));
            }
        }
        return ans;
    }
};
```
当然了，在大的case上超时也是命中注定的。。。。。。。

看了一下标签--->栈，然后本周学的内容也是栈相关。。。可是，可是。。。。让我用栈来做！！臣妾做不到啊！
### 二，分治
于是乎，打开题解，看到分治法，**虎躯**一震，妈呀，优雅，于是顺手写了一个。
```
// 分治法来做
// 找到数组中最小的元素下标mid
// S[start,end] = max(mid*(end-start+1),S[start,mid-1],S[mid+1,end])
class Solution {
public:
    int max3(int x,int y,int z){
        return max(x,max(y,z));
    }
    int S(vector<int>& heights,int start,int end){
        if(start>end){
            return 0;
        }
        int curMin = heights[start];
        int mid = start;
        for(int i=start;i<=end;i++){
            if(heights[i]<curMin){
                mid = i;
                curMin = heights[i];
            }
        }
        return max3(curMin*(end-start+1),S(heights,start,mid-1),S(heights,mid+1,end));
    }
    int largestRectangleArea(vector<int>& heights) {
        return S(heights,0,(int)heights.size()-1);
    }
};
```
但执行效率让人心疼，时间复杂度为O(nlogn)，但是最坏会退化O(n^2)，例如当数组有序。
空间复杂度为O(n)，因为递归要访问到每一个元素。

### 三，优化分治法
事实上，我们看到上面的分治法里面涉及一个求区间最小值的过程，我们可以用**线段树**优化， 官网题解里有前辈做了这样一颗线段树，**R.I.P**。
### 四，压轴选手，栈
我们需要首先搞清楚一个问题：**第i个位置最大的面积是什么？**答：是以i为中心，向左找到第一个**小于**它的元素m，向右找到第一个**小于**他的元素n。 那么第i个位置嘴的面积为：

**heights[i]*(m-n-1)**

维护一个**单调递增的栈**，why？因为当我们找到比栈顶元素小的i时，代表栈顶元素的左右边界已经找到了。

```
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> s;
        s.push(-1);    //方便处理 
        int ans = 0;
        for(int i=0;i<heights.size();i++){
            if(s.top()!=-1&&heights[i]<heights[s.top()]){
            	//当遇到第i个元素小于栈顶元素时
				//这时说明，栈顶元素的左右边界找到了。
				//左边界为 栈顶下的元素，有边界为i 
                while(s.top()!=-1&&heights[s.top()]>=heights[i]){
                    int temp = s.top();
                    s.pop();
                    ans = max(ans,heights[temp]*(i-s.top()-1));
                }
            }
            s.push(i);
        }
        //此时若栈非空，说明栈里面是递增的。
		//栈里元素的右边界为 heights.lenght。很好理解。 
        while(s.top()!=-1){
            int temp = s.top();
            s.pop();
            ans = max(ans,heights[temp]*((int)heights.size()-s.top()-1));
        }
        return ans;
    }
};
```

## LeetCode-239 滑动窗口最大值
看到这题后，我瞬间就觉得这就是之前每日一题打卡**队列最大值**的变种，我更改了那个代码，提交是AC的。
```
class Solution {
public:
class MaxQueue {
    public:
        MaxQueue() {
            //op
        }
        int max_value() {
            if(d.empty())
                return -1;
            return d.back();
        }
        
        void push_back(int value) {
            while(!d.empty()&&d.front()<value){
                d.pop_front();
            }
            d.push_front(value);
            q.push(value);
        }
        
        int pop_front() {
            if(q.empty())
                return -1;
            int ans = q.front();
            q.pop();
            if(ans==d.back()){
                d.pop_back();
            }
            return ans;
        }
    private:
        queue<int> q;
        deque<int> d;
 };
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        int n = nums.size();
        if(!n||!k)
            return ans;
        MaxQueue myqueue;
        for(int i=0;i<k;i++){
            myqueue.push_back(nums[i]);
        }
        ans.push_back(myqueue.max_value());
        for(int i=k;i<nums.size();i++){
            myqueue.pop_front();
            myqueue.push_back(nums[i]);
            ans.push_back(myqueue.max_value());
        }
        return ans;
    }
};
```
当然题解也是双端队列，至于动态规划的解法，因为对动态规划不熟悉，所以便跳过吧，等学了DP再回来看。

##  LeetCode-49 字母异位词分组
思路：排序后的字母异位词相等，以其为key，然后将所有排序后相等的词归纳为一组。

```
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string,vector<string> > record;
        for(int i=0;i<strs.size();i++){
            string temp = mysort(strs[i]);  //这里mysort是利用计数排序，O(N) 
            record[temp].push_back(strs[i]);
        }
        for(auto i:record){
            ans.push_back(i.second);
        }
        return ans;
    }
    //计数排序
    string mysort(string s){
        int ch[26] = {0};
        string ans = "";
        for(auto i:s){
            ch[i-'a']++;
        }
        for(int i=0;i<26;i++){
            ans+=string(ch[i],i+'a');
        }
        return ans;
        
    }
};
```
##  LeetCode-42 接雨水
这个题值得反复看。
### 一，暴力
思路：对于每一个元素，所能储存的水量为两边高度最大值的较小值减去当前高度的值。
```
int trap(vector<int>& height)
{
    int ans = 0;
    int size = height.size();
    for (int i = 1; i < size - 1; i++) {
        int max_left = 0, max_right = 0;
        for (int j = i; j >= 0; j--) { //查找左边最大值
            max_left = max(max_left, height[j]);
        }
        for (int j = i; j < size; j++) { //查找右边最大值
            max_right = max(max_right, height[j]);
        }
        ans += min(max_left, max_right) - height[i];
    }
    return ans;
}
```
### 二，备忘录
思路：再暴力法中，我们看到，我们每次都需要遍历 [0,i]的最大值 lmax，和[i,end]的最大值lmax。我们当然可以提前存储这个值，**空间换时间**
```
int trap(vector<int>& height)
{
	if(height == null)
		return 0;
    int ans = 0;
    int size = height.size();
    vector<int> left_max(size), right_max(size);   //备忘录
    //对lmax做备忘
    left_max[0] = height[0];
    for (int i = 1; i < size; i++) {
        left_max[i] = max(height[i], left_max[i - 1]);
    }
    //rmax做备忘
    right_max[size - 1] = height[size - 1];
    for (int i = size - 2; i >= 0; i--) {
        right_max[i] = max(height[i], right_max[i + 1]);
    }
    //calculate
    for (int i = 1; i < size - 1; i++) {
        ans += min(left_max[i], right_max[i]) - height[i];
    }
    return ans;
}
```
### 三，双指针
思路：我们从备忘录法可以看出，当i位置的左侧最大值小于右侧最大值时，那么，i所能装的水只与i左侧最高的柱子有关。**（水量决定于矮的那个柱子）**
```
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int ans = 0;
        int left = 0,right = n-1;
        int lmax = 0,rmax = 0;
        while(left<right){
            if(height[left]<height[right]){
            	//当left的值小于right的值，此时我们处理left处的水量 
            	//因为如果处理right的值
				//并不能保证right左边有没有大于right的值
				//但处理left，可以保证left右侧有大于left处的值 
                if(lmax<=height[left]){
                    lmax = height[left];
                }
                ans+= (lmax-height[left++]);
            }else{
            	//同理 
                if(rmax<=height[right]){
                    rmax = height[right];
                }
                ans+=(rmax-height[right--]);
            }
        }
        return ans;
    }
};
```

### 四，栈
最一开始，和84题一样，我始终无法理解这一题为啥和栈相关联，直到，我看到网络上的高票题解里的一幅图。
![alt 接雨水](https://pic.leetcode-cn.com/37fccd915f959c2046ffc1ab2b0a1e4d921869337d8d5d4aa218886ab0bf7c8a-image.png)
我承认我悟了，一瞬间，我感觉84题，这一题，本质都和括号匹配一样的。

你需要理解，**括号是什么意思**，括号界定了它能容纳的水量。**左括号和右括号之间的元素小于等于他们**



**总的蓄水量 = 总的括号界定的水量**



而括号界定的水量为：

设左括号的位置：l   右括号位置：r

那么 ，括号界定的水量为： **{min(height[l],height[r])-max(height(l....r)}*width**，其中，**width = r-l-1**

```
class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> s;
        int ans = 0;
        for(int i=0;i<height.size();i++){
            while(!s.empty()&&height[i]>height[s.top()]){
                int t = s.top();
                s.pop();
                if(s.empty())
                    break;
                ans+=(min(height[i],height[s.top()])-height[t])*(i-(int)s.top()-1);
            }
            s.push(i);
        }
        return ans;
    }
}; 
```

##  LeetCode-6 设计循环双端队列
这道题我的第一直观想法就是用双向链表，因为它直观啊。但效率不佳，耗内存，不快，对于大数据，对缓存也不友好，就不献丑了，直接研究利用数组做法，这是个**经典**的做法，经典意味着它并不是那么容易想到，因为很巧妙。

1. 定义数组 arr，开空间k+1，因为我们要舍弃一个元素的位置（为了区分判空和判满）
2. 定义front索引，代表**头部的第一个有效数据的位置**
3. 定义rear索引，代表**最后一个有效数据的下一个位置**。不要问为什么，问就是经典。

* 判空：**front == rear**
* 判满：**(rear+1)%capacity == front。**
```
//设计循环双端队列
//front 队头的第一个有效元素的位置 
//rear 队尾最后一个有效元素的下一个位置，经典做法。 
class MyCircularDeque {
public:
    MyCircularDeque(int k) {
        capacity = k+1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }
    
    bool insertFront(int value) {
        if(isFull())
            return false;
        front = (front-1+capacity)%capacity;
        arr[front] = value;
        return true;
    }
    
    bool insertLast(int value) {
        if(isFull())
            return false;
        arr[rear] = value;
        rear = (rear+1)%capacity;
        return true;
    }
    
    bool deleteFront() {
        if(isEmpty())
            return false;
        front = (front+1)%capacity;
        return true;
    }
    
    bool deleteLast() {
        if(isEmpty())
            return false;
        rear = (rear-1 + capacity)%capacity;
        return true;
    }
    
    int getFront() {
        if(isEmpty())
            return -1;
        return arr[front];
    }
    
    int getRear() {
        if(isEmpty())
            return -1;
        return arr[(rear-1+capacity)%capacity];
    }
    
    bool isEmpty() {
        return front==rear;
    }
    
    bool isFull() {
        return (rear+1)%capacity == front;  //经典做法
    }
private:
    int* arr;
    int front;    
    int rear;
    int capacity;    
};
```