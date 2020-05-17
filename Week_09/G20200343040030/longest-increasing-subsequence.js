/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    const len = nums.length
    if (len == 0) return 0
    if (len == 1) return 1
    let dp = new Array(len).fill(1)
    for (let i = 1; i < len; i++) {
        for (let j = 0; j < i; j++) {
            dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 1)
        }
    }
    dp.sort((a, b) => b - a)
    return dp[0]
};