class Solution {
    public int maxProfit(int[] prices) {
        int allProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                allProfit += prices[i] - prices[i - 1];
            }
        }
        return allProfit;
    }
}