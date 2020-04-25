# 算法笔记
## 	leetcode-26 删除排序数组中的重复项
思路：双指针，维护指针i，指针j，区间[0,i]表示不重复的集合，j表示当前访问的元素
算法：
	loop nums:
		if nums[j]!=nums[i] then nums[++i] = nums[j];
代码：
```
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(!nums.size())
            return 0;
        int i;
        int j;
        for(i=0,j=1;j<nums.size();j++){
            if(nums[i]!=nums[j])
                nums[++i] = nums[j];
        } 
        return i+1;
    }
};
```
拓展：leetcode-80 删除数组中重复项
思路: 与26题的easy版本没什么不同，只是这次多了一个限制条件即元素最多重复两次。我们只需相应的多增加一个判定条件
代码：
```
class Solution {
public:
    //维护指针i，j
    //指针i表示[0,i]区间的元素为确定放进最终结果的元素集合
    //j表示当前遍历的元素，判断是否加进结果集合
    int removeDuplicates(vector<int>& nums) {
        if(!nums.size())
            return 0;
        int i;
        int j;
        for(i=0,j=1;j<nums.size();j++){
            if(nums[j]!=nums[i]||(!(i>0&&nums[i]==nums[i-1]))){
                //if里的判断为：当前元素不等于nums[i]并且nums[i]!=nums[i-1]
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
};
```
## LeetCode-189 旋转数组
要求：使用O(1)空间的原地算法。
### 方法一 暴力

最直观的暴力解法，写一个旋转一次的函数，然后调用k次;   Time-O(K*n) Space-O(1)

代码：

```
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(n)
            k = k%n;
        if(!n||!k||k==n)
            return ;
        for(int i=0;i<k;i++){
            int start = 0;
            int prev = nums[n-1];
            for(int j=0;j<n;j++){
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
        return ;
    }
};
```

缺点是时间复杂度太高，在leetcode上最后一个case是不通过的。
### 方法二 增加一个数组记录
空间换时间，开辟一个相同大小的数组arr，令arr[i] = nums[(i+k)%n];  Time-O(n) Space-O(n)
```
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(n)
            k = k%n;
        if(!n||!k||k==n)
            return ;
        int arr[n];
        for(int i=0;i<n;i++){
            arr[(i+k)%n] = nums[i];  //这里比较tricky需要特别注意
        }
        for(int i=0;i<n;i++){
            nums[i]= arr[i];
        }
        return ;
    }
};
```

上面的代码已经蛮不错了，但是O(n)的空间复杂度对于强迫症的我来说还是不够。

### 环状数组遍历
![](https://pic.leetcode-cn.com/f0493a97cdb7bc46b37306ca14e555451496f9f9c21effcad8517a81a26f30d6-image.png)
环状数组遍历，不过我们要小心出现局部环状，要记录一个start索引，当回到start时，从start下一个继续进行  Time-O(n) Space-O(1);



```
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int numLen = nums.size();
        k = k%numLen;
        if(!numLen||!k)
            return ;              //当数组为空，或者k==0 直接返回
        int count = numLen;       //count表示我们仍需要执行count次赋值
        int start = 0;            //start表示局部circle的起点
        int curI = 0;             //current index表示当前操作的结点。
        int preVal = nums[0];     //previous value作为暂存值，存取被覆盖的元素的值。
        while(count){
            do{
                int temp = nums[(curI+k)%numLen];
                nums[(curI+k)%numLen] = preVal;
                preVal = temp;
                count--;
                curI = (curI+k)%numLen;
                
            }while(curI!=start);
            start = ++curI;
            preVal = nums[start];
        }
        return ;
    }
};
```

这种算法不容易写，一旦粗心就会出现bug，但容易想到且高效，处理好边界条件，注意细节即可。

### 三次reverse
这种写法真的超级tricky了，看到答案的我是又惊又喜，真牛逼，不过下次我就能写对了，充满自信，我是来刷题的，不是创造解法的。。
```
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(n)
            k = k%n;
        if(!n||!k)
            return ;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        return ;
    }
    void reverse(vector<int>& nums,int begin,int end){
        while(begin<end){
            swap(nums[begin++],nums[end--]);
        }
        return ;
    }
};
```

## LeetCode-21 合并两个有序链表
链表具备天然的递归性质，所以对于链表题，我们一般都可以用递归做，当然可能会比较难想，但是可以锻炼自己写递归的能力。

### 递归解法：
```
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(!l2)
            return l1;
        if(!l1)
            return l2;
        ListNode* cur;
        if(l1->val>l2->val){
            cur = l2;
            l2 = l2->next;
        }else{
            cur = l1;
            l1 = l1->next;
        }
        cur->next = mergeTwoLists(l1,l2);
        return cur;
    }
};
```

### 非递归解法，使用dummyHead
```
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* dummyNode = new ListNode(INT_MIN);
        ListNode* tail = dummyNode;
        while(l1||l2){
            if(!l1){
                tail->next = l2;
                break;
            }
            if(!l2){
                tail->next = l1;
                break;
            }

            if(l1->val>=l2->val){
                tail->next = l2;
                tail = l2;
                l2 = l2->next;
            }else{
                tail->next = l1;
                tail = l1;
                l1 = l1->next;
            }
        }
        return dummyNode->next;
    }
};
```
## LeetCode-88 合并两个有序数组
这一题，思路非常简单，三指针即可。 但我性格太糙，很容易写出在某个case失败的代码，不知道如何解决。


```
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {

        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while(p2>=0){
            nums1[p--] = p1<0?nums2[p2--]:(nums1[p1]>=nums2[p2]?nums1[p1--]:nums2[p2--]);     //此时需要注意i<0的情况
                     //比如case: nums1=>[4,5,6,0,0,0] nums2=>[1,2,3]
        }
        return ;
    }
};
```

## LeetCode-1 两数之和

这道题是我心中之痛，记得之前面试字节跳动，就给了这个题，当时的自己太过孱弱。

### 哈希表+一遍扫描
```
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        unordered_map<int,int> record;
        int temp[2];
        for(int i=0;i<nums.size();i++){
            if(record.find(target-nums[i])!=record.end()){
                temp[0] = record[target-nums[i]];
                temp[1] = i;
                return vector(temp,temp+2);
            }
            record[nums[i]] = i;
        }
        return ans;
    }
};
```

## LeetCode-66 加一
第一眼看到这题，我心中暗自一喜，呵！这不是经典的模拟加法的题目嘛！不管三七二十一，写个carry变量，然后从后往前循环相加。最后不忘判断一下是否出现999+1这种情况。于是乎，下面这丑陋的代码就被我 写出来：
```
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int i = digits.size()-1;
        int carry = 1;
        while(i>=0){
            int temp = (digits[i]+carry)/10;
            digits[i] = (digits[i]+carry)%10;
            carry = temp;
            i--;
        }
        if(carry>0){
            digits.insert(digits.begin(),carry);
        }
        return digits;
    }
};
```
我甚至暗暗窃喜，这似乎是bugfree的，可是一提交，击败20%的用户。肯定是有什么tricky的写法！！按照超哥的指示，我直接找到了精选题解。果然！！！！
1，对于本题而言，数组里的所有元素只有两种情况，加1和不加1，所以不需要carry这个变量
2，对于99，9999而言，直接返回100，10000这样子

如下代码，非常优雅（tricky）
```
class Solution {
public:
    vector<int> plusOne(vector<int>& digits){
        for(int i=(int)digits.size()-1;i>=0;i--){
            digits[i]+=1;
            digits[i]%=10;
            if(digits[i]!=0){
                return digits;
            }
        }
        vector<int> ans = vector(digits.size()+1,0);
        ans[0] = 1;
        return ans;
    }
};
```