/*
 * @Author: mingxing.huang
 * @Date: 2020-04-03 10:23:28
 */
/**
 * 122. 买卖股票的最佳时机 II
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  // 思路：贪心，只要能赚钱就买卖，[1,5,6]，虽然6-1 = (5-1) + (6-5)，
  // 但是这是连续上涨的情况，如果中间有波动，比如：[1,5,3,6]，6-1 < (5 - 1) + (6 - 3)
  let res = 0;
  for (let i = 1; i < prices.length; i++) {
    if (prices[i] > prices[i - 1]) {
      res += prices[i] - prices[i - 1];
    }
  }
  return res;
};
