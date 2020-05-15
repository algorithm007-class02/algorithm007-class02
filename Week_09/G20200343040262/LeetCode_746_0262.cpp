/*
 * @lc app=leetcode.cn id=746 lang=cpp
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
public:
    int minCostClimbingStairs(vector<int> &cost) {
        int f1 = cost[0], f2 = cost[1];
        for (int i = 2; i < cost.size(); ++i) {
            int f3 = cost[i] + min(f1, f2);
            f1 = f2;
            f2 = f3;
        }
        return min(f1, f2);
    }
};
// @lc code=end
