/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  var total = 0; // 总利润
  var i = 0;

  while(i < prices.length - 1) {
      if (prices[i] < prices[i + 1]) {
          total += (prices[i+1] - prices[i]);
      }

      i++;
  }

  return total;
};