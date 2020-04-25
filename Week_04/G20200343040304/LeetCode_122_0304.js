/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let i = 0;
  let j = 1;
  let totalPrice = 0;
  while (j < prices.length) {
    if (prices[i] <= prices[j]) {
      totalPrice += prices[j] - prices[i];
      i++;
      j++;
    } else {
      i = j;
      j = i + 1;
    }
  }
  return totalPrice;
};