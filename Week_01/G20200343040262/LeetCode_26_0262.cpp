/*
LeetCode
（删除排序数组中的重复项）题目26描述：
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
*/

//老套路：双指针

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0,j = 1;
        int n = nums.size();
        if (n == 0) return n;//空数组
        if (n == 1) return n;//单元素数组
        while (j < n) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
};