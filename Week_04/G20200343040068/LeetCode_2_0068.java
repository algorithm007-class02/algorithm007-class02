class LeetCode_2_0068 {

    //明天的价格高于今天，即今天买，明天卖
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0;i < prices.length - 1;i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}