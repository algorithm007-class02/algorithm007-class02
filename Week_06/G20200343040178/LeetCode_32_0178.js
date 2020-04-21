/*
 * @Author: mingxing.huang
 * @Date: 2020-04-18 13:18:25
 */
/**
 * 最长有效括号
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function (s) {
    /**
     * dp[i]：[0,i]子串构成的最长有效括号的长度
     * if s[i] = '('，dp[i] = dp[i - 1]
     * if s[i] = ')'，
     *  if s[i-1] = '('，dp[i] = dp[i - 2] + 2
     *  if s[i-1] = ')'，if s[i - dp[i - 1] - 1] = '('，dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
     *      ()(())
     *      012345
     */
    let res = 0;
    let len = s.length;
    let dp = Array(len).fill(0);
    for (let i = 1; i < len; i++) {
        if (s[i] === ')') {
            if (s[i - 1] === '(') {
                dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] === '(') {
                let front = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0;
                dp[i] = front + dp[i - 1] + 2;
            }
            res = Math.max(res, dp[i]);
        }
    }
    return res;
}