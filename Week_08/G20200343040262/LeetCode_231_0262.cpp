/*
 * @lc app=leetcode.cn id=231 lang=cpp
 *
 * [231] 2的幂
 */

// @lc code=start
// 2的幂次数的二进制位只会有一个1
class Solution {
public:
    bool isPowerOfTwo(int n) {
        // 清零最低位的1
        return ((n > 0) && (n & (n - 1)) == 0);
    }
};
// @lc code=end
