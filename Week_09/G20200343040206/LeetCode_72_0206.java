
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_72_0206 {
    /**
     * dp[i][j]:
     * i: word1从头到第i个字符
     * j：word2从头到第j个字符
     * dp[i][j]:从头到word1的第i个字符，转换成从头到word2的第j个字符，需要进行的最少操作数
     * if w1[i] == w2[j] : dp[i][j] = dp[i-1][j-1],
     * else： dp[i][j] = 1  +  min(dp[i-1][j-1],dp[i-1][j], dp[i][j-1])
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0) {
            return -1;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length() ; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length() ; j++) {
            dp[0][j] = j;
        }


        for (int i = 1; i <= word1.length() ; i++) {
            for (int j = 1; j <= word2.length() ; j++) {

                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] =  dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

            }
        }
        return dp[word1.length()][word2.length()];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
