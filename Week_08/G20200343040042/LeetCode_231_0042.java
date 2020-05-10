package com.yequan.leetcode.bit.isPowerOfTwo_231;

/**
 * //给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * //
 * // 示例 1:
 * //
 * // 输入: 1
 * //输出: true
 * //解释: 20 = 1
 * //
 * // 示例 2:
 * //
 * // 输入: 16
 * //输出: true
 * //解释: 24 = 16
 * //
 * // 示例 3:
 * //
 * // 输入: 218
 * //输出: false
 * // Related Topics 位运算 数学
 *
 * @author : Administrator
 * @date : 2020/5/3
 */
public class IsPowerOfTwo {

    /**
     * 清除n最低位的 1, 清除次数为1的为正解
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count == 1;
    }

}
