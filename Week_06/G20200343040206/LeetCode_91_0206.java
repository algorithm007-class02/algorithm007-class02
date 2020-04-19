
//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_91_0206 {
    //递归
    //从后往前，f(s, start) = f(s, start+1) +f(s, start+2)
    //如果起始位是0，直接就是0
    public int numDecodings(String s) {
        if (s== null || s.length()==0) {
            return 0;
        }
        return calDecodeings(s, 0);
    }
    private int calDecodeings(String s, int start){
        //终止条件
        if (s.length() == start){
            return 1;
        }
        if (s.charAt(start)== '0') {
            return 0;
        }

        //处理当前层逻辑

        //递归
        // 如果index的后两位小于等于26，
        // f(s, start) = f(s, start+1) +f(s, start+2)
        // 否则digui(s, start) = digui(s, start+1)
        int count1 = calDecodeings(s, start+1);
        int count2 = 0;
        if (start < s.length()-1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if(ten + one <= 26) {
                count2 = calDecodeings(s, start + 2);
            }
        }
        return count1 + count2;

        //还原现场
    }

    //一维dp
    //nums[i] = '0', dp[i] = 0
    //nums[i] * 10 + nums[i-1] <= 26, dp[i] = dp[i-1] + dp[i-2]
    //nums[i] * 10 + nums[i-1] > 26, dp[i] = dp[i-1]
    public int numDecodings_2(String s) {
        if (s== null || s.length()==0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0]=1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int sencode = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <=9) {
                dp[i] += dp[i - 1];
            }
            if (sencode >= 10 && sencode <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
