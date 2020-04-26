/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int f1 = 1, f2 = 2, f3 = 0;
        for (int i = 2; i < n; ++i) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
// @lc code=end

