//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=91 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s) {
        $n = strlen($s);
        if ($n == 0 || $s[0] == 0) return 0;
        $dp = [];
        $dp[0] = 1;
        if (substr($s, 0, 2) <= '26') $dp[1] = $s[1] == 0 ? 1 : 2;
        else $dp[1] = $s[1] == 0 ? 0 : 1;
        for ($i = 2; $i < $n; $i++) {
            if ($s[$i - 1] != 1 && $s[$i - 1] != 2) {
                if ($s[$i] == '0') return 0;
                else $dp[$i] = $dp[$i - 1];
            } else {
                $dp[$i] = $s[$i] == 0? $dp[$i - 2] : (substr($s, $i - 1, 2) <= '26' ? $dp[$i - 1] + $dp[$i - 2] :$dp[$i - 1]);
            }
        }
        return $dp[$n - 1];
    }
}
// @lc code=end
