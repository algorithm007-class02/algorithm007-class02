class Solution {

    /**
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            sum += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return sum;
    }
}