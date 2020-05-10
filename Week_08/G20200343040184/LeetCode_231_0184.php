//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=231 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 输入: 218
 * 输出: false
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * @param Integer $n
     * @return Boolean
     */
    function isPowerOfTwo($n) {
        //return $n > 0 && ($n & -$n) == $n; //获取最右边的1
        return $n > 0 && ($n & ($n - 1)) == 0; //移除最右边的1
    }

    function isPowerOfTwo2($n) {
        if ($n == 0) return false;
        while ($n % 2 == 0) $n /= 2;
        return $n == 1;
    }
}
// @lc code=end
