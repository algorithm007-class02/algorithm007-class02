/**
 * @param {number[]} nums
 * @return {number}
 */
var maxCoins = function(nums) {
  nums.push(1);
  nums.unshift(1);
  const len = nums.length;
  let dp = new Array(len).fill(0).map(() => new Array(len).fill(0));

  for (let space = 1; space < len; space++) {
      for (let i = 0; i + space < len; i++) {
          for (let j = i + 1; j < i + space; j++) {
              dp[i][i + space] =
              Math.max(dp[i][i + space], dp[i][j] + dp[j][i + space] + nums[i] * nums[j] * nums[i + space]);
          }
      }
  }
  return dp[0][nums.length - 1];
};