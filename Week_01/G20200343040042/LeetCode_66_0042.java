package com.yequan.leetcode.array.plusone_66;

import com.yequan.leetcode.array.ArrayUtil;

/**
 * //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * //
 * // 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * //
 * // 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,2,3]
 * //输出: [1,2,4]
 * //解释: 输入数组表示数字 123。
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: [4,3,2,1]
 * //输出: [4,3,2,2]
 * //解释: 输入数组表示数字 4321。
 * //
 * // Related Topics 数组
 *
 * @author : Administrator
 * @date : 2020/3/13
 */
public class PlusOne {

    /**
     * 末位加1
     * 只考虑末位是9还是非9的情况,以及9,99,999等需要增加1位的情况
     * 末位非9,直接加1
     * 末位为9,考虑层层进位
     * <p>
     * 这种算法的思想可以解决超大数的运算问题
     *
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        if (null == digits || digits.length == 0) {
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 数学加法:
     * 解析数组,将数组转变成int,然后加1
     * 将所得结果转换成数组
     * <p>
     * 此方法只适用于数值小于Integer.MAX_VALUE
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        if (null == digits || digits.length == 0) {
            return null;
        }
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum = sum + digits[i] * ((int) Math.pow(10, digits.length - 1 - i));
        }
        sum++;
        String resultString = String.valueOf(sum);
        int[] result = null;
        if (resultString.length() == digits.length) {
            result = digits;
        } else {
            result = new int[resultString.length()];
        }
        for (int i = 0; i < resultString.length(); i++) {
            String substring = resultString.substring(i, i + 1);
            result[i] = Integer.parseInt(substring);
        }
        return result;
    }
}
