package com.alang.learn.week8;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 * 通过次数57,183提交次数119,148
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_231_0034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(11));
        System.out.println(solution.isPowerOfTwo(128));
        System.out.println(solution.isPowerOfTwo(-3));
    }

    static public class Solution {
        public boolean isPowerOfTwo(int n) {
            return !(n <= 0) && (n & (n-1)) == 0;
        }
    }
}
