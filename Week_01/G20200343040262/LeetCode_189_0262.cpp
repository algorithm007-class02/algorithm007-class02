/*
LeetCode
（旋转数组）题目189描述：
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
*/

//三重反转，是个套路，不知道还有没有其他套路

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k % n;
        reverse(nums.begin(), nums.end() - k);
        reverse(nums.end() - k, nums.end());
        reverse(nums.begin(), nums.end());
    }
};