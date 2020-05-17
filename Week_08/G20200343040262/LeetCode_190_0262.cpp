/*
 * @lc app=leetcode.cn id=190 lang=cpp
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t res = 0;
        int index = 32; //操作32次移位操作
        while (index--) {
            res <<= 1;    //结果左移一位，空出位置与n最后一位相加
            res += n & 1; //加上n的最后一位
            n >>= 1;      // n右移一位，供下一轮与结果相加
        }
        return res;
    }
};
// @lc code=end
