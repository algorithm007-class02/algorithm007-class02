
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_231_0206 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long)n;
        //2 的幂次方:二进制表示中只有1位为1，其他位都是0
        return (x & (x-1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
