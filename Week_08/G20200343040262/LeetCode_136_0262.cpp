/*
 * @lc app=leetcode.cn id=136 lang=cpp
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
public:
    int singleNumber(vector<int> &nums) {
        int a = 0;
        for (int b : nums) {
            a ^= b;
        }
        return a;
    }
};
// @lc code=end
