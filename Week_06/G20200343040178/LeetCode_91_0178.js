/*
 * @Author: mingxing.huang
 * @Date: 2020-04-18 23:27:44
 */
/**
 * 解码方法
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
    /**
     * dp[i]:以s[i]结尾的子串解码个数
     * 如果s[i - 1]等于1或者2
     *      如果s[i]等于0，dp[i] = dp[i - 2]
     *      如果s[i]不等于0，如果s[i-1, i]可以解码，dp[i] = dp[i - 2] + dp[i - 1]
     *                     如果s[i-1, i]不可以解码，dp[i] = dp[i - 1]
     * 如果s[i - 1]不等于1或者2，
     *      如果s[i]等于0，不能解码，返回0
     *      如果s[i]不等于0，独立解码，dp[i] = dp[i - 1]
     */
    if (s[0] === '0') return 0;
    if (s.length === 1) return 1;
    let dp = Array(s.length).fill(0);
    dp[0] = 1;
    if (s.substring(0, 2) <= '26') {
        dp[1] = s[1] === '0' ? 1 : 2;
    } else {
        dp[1] = s[1] === '0' ? 0 : 1;
    }
    for (let i = 2; i < s.length; i++) {
        if (s[i - 1] === '1' || s[i - 1] === '2') {
            if (s[i] === '0') {
                dp[i] = dp[i - 2];
            } else {
                let sub = s.substring(i - 1, i + 1);
                if (sub >= '1' && sub <= '26') {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        } else {
            if (s[i] === '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }
        }
    }
    return dp[s.length - 1];
};