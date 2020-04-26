/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
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
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）
 */
class Solution {
    public int numDecodings(String s) {
        int len  = s.length();
        if (len == 0) return 0;
        int[] res = new int[len + 1];
        res[0] = 1;
        res[1] = s.charAt(0) == '0' ? 0 : 1;
        int one = 0, two = 0;
        for (int i = 2; i <= len; ++i ) {
            one = Integer.parseInt(s.substring(i - 1,i));
            two = Integer.parseInt(s.substring(i - 2,i));
            if (one >= 1 ) {
                res[i] += res[i - 1];
            }
            if (two >= 10 && two <= 26) {
                res[i] += res[i - 2] ;
            }
        }
        return res[len];
    }
}