/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (43.29%)
 * Likes:    438
 * Dislikes: 0
 * Total Accepted:    127.6K
 * Total Submissions: 294K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int andOne = 1;
        for (int i = digits.length - 1; i >=0; i--) {
            int sum = digits[i] + andOne;
            digits[i] = sum % 10;
            andOne = sum / 10;
        }
        if (andOne == 0)  return digits;
        else {
            int[] res = new int[digits.length + 1];
            res[0] = andOne;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
    
    }
}
// @lc code=end