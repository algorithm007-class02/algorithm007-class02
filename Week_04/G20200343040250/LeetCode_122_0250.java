class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int currIndex = 0;
        // 贪心算法，当下一天比当天价格高，就获得利润（先买后卖）
        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[currIndex];
            if (sub > 0) {
                total += sub;
            }
            currIndex++;
        }
        return total;
    }
}