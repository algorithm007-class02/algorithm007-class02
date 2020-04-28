/*
 * @Author: mingxing.huang
 * @Date: 2020-04-23 16:34:19
 */
/**
 * 爬楼梯
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    // dp
    // let dp = Array(n + 1);
    // dp[1] = 1;
    // dp[2] = 2;
    // for (let i = 3; i <= n; i++) {
    //     dp[i] = dp[i - 1] + dp[i - 2];
    // }
    // return dp[n];

    // 优化空间复杂度
    if (n < 3) return n;
    let cur = 2;
    let pre = 1;
    let res = 0;
    for (let i = 3; i <= n; i++) {
        res = pre + cur;
        pre = cur;
        cur = res;
    }
    return res;
}