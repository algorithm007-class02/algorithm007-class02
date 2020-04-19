class Solution {
    /**
     * 峰谷算法
     * 时间 O(N)
     * 空间 O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int valley = prices[0];
        int peak = prices[0];
        int maxProfitValue = 0;
        int i = 0;
        for (; i < prices.length - 1; ) {

            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];

            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            peak = prices[i];

            maxProfitValue += peak - valley;
        }
        return maxProfitValue;
    }

    /**
     * 峰值算法优化
     *
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfitValue = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfitValue += prices[i + 1] - prices[i];
            }
        }
        return maxProfitValue;
    }
}