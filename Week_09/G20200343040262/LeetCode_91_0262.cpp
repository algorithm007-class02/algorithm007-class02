/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 */

// @lc code=start
/*
dp[i]:从0到i位的解码方法总数
当s[i]是 “0”的时候，s[i]无法解码，返回0.
当s[i]不是“0”的时候:
    如果s[i-1]s[i]组成的数字小于等于26，则可以联合解码;
    否则，s[i]独立解码.
*/
class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        vector<int> dp(n + 1);
        dp[n] = 1;
        for (int i = n - 1; i >= 0; --i) {
            if (s[i] == '0')
                dp[i] = 0; // s[i] cannot decode
            else {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (s[i] == '1' || s[i] == '2' && s[i + 1] < '7'))
                    dp[i] += dp[i + 2];
            }
        }
        return s.empty() ? 0 : dp[0];
    }
};
// @lc code=end
