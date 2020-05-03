/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (47.86%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    56.3K
 * Total Submissions: 117.3K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n-1)) == 0 && n > 0) ? true : false;
    }
}
// @lc code=end

