package week04.g20200343040172;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * LeetCode-122 Best time to buy and sell stock 买卖股票的最佳时机
 */
public class LeetCode_122_0172 {

    /**
     * 使用贪心算法
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == prices.length - 1) {
                return max;
            }
            if (prices[i] < prices[i + 1]) {
                max += (prices[i + 1] - prices[i]);
            }
        }
        return max;
    }
    /**
     * 动态规划的解法，真不懂！！！
     * @param prices
     * @return
     */
    public static int maxProfit_2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态数组
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        int[] cash = new int[len];
        int[] hold = new int[len];

        cash[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[len - 1];
    }
}
