/*
 * @lc app=leetcode.cn id=191 lang=cpp
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            // 清零最低位的1
            n &= (n - 1);
        }
        return cnt;
    }
};
// @lc code=end
