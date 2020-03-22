/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */

var climbStairs = function (n) {
    let f1 = 1,
        f2 = 2,
        f3 = 3
    if (n < 3) {
        return n == 1 ? f1 : f2
    }

    for (let i = 3; i < n + 1; i++) {
        f3 = f1 + f2;
        f1 = f2;
        f2 = f3;
    }

    return f3
};
// @lc code=end

