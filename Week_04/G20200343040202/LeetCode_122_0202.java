class Solution {
    public int maxProfit(int[] prices) {
        int value = 0;
        for (int i = 1; i < prices.length; ++i) {
            int money = prices[i] - prices[i - 1];
            value += money > 0 ? money : 0;
        }
        return value;
    }
}