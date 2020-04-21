package com.alang.learn.week6;

/***
 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

 你可以对一个单词进行如下三种操作：

 插入一个字符
 删除一个字符
 替换一个字符
  

 示例 1：

 输入：word1 = "horse", word2 = "ros"
 输出：3
 解释：
 horse -> rorse (将 'h' 替换为 'r')
 rorse -> rose (删除 'r')
 rose -> ros (删除 'e')
 示例 2：

 输入：word1 = "intention", word2 = "execution"
 输出：5
 解释：
 intention -> inention (删除 't')
 inention -> enention (将 'i' 替换为 'e')
 enention -> exention (将 'n' 替换为 'x')
 exention -> exection (将 'n' 替换为 'c')
 exection -> execution (插入 'u')

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/edit-distance
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_72_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse","ros"));
        System.out.println(solution.minDistance("intention","execution"));
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            int n1 =  word1.length();
            int n2 = word2.length();
            if (n1 * n2 == 0) return n1 + n2;
            int[][] dp = new int[n1+1][n2+1];
            for(int i = 1;i<n1+1;i++) dp[i][0] = dp[i-1][0]+1;
            for(int j = 1;j<n2+1;j++) dp[0][j] = dp[0][j-1]+1;
            for(int i = 1;i<=n1;i++){
                for(int j = 1;j<=n2;j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){//
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1],dp[i][j - 1]),dp[i - 1][j]);
                    }
                }
            }
            return dp[n1][n2];
        }
    }
}
