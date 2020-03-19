class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverse(nums, 0, nums.size() - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.size() - 1);
    }

    void reverse(vector<int>& nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
};
// 时间复杂度 0(n)
// 空间复杂度0(1)


// 方法1： 遍历数组， 创建1个新的数组， 新的数组的下标就是 ( 原下标 + k ) % 数组长度， 然后返回新的数组 
// 方法2： 翻转数组，翻转3次， 先翻转整个数组， 然后翻转前面k, 再翻转后面部分。

// @lc code=end

