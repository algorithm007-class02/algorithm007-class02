public class LeetCode_121_0222 {

    /**
     * 暴力法 时间复杂度 O(N^2) 空间复杂度为O(1)  N表示数组长度
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    /**
     * 暴力法优化 时间复杂度O(N) 空间复杂度为O(1) N 表示数组长度
     * @param prices
     * @return
     */
    public int maxProfitRe1(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }

    /**
     * 动态规划1 时间复杂度O(N) 空间复杂度为O(N) N表示数组长度
     *
     * 1状态定义 天数代表每个阶段，即一天一天看，设置为第一维。为了消除后效性（前面的状态确定下来以后不会因为后面状态而更改），将当天是否持股设置为第二维的状态。于是：
     * 状态 dp[i][j] 表示：在索引为 i 的这一天，用户手上持股状态为 j 所获得的最大利润
     * 说明：
     * j 只有 2 个值：0 表示不持股（特指卖出股票以后的不持股状态），1 表示持股。
     * “用户手上不持股”不代表用户一定在索引为 i 的这一天把股票抛售了
     * 2状态转移方程
     * dp[i - 1][0] ：当然可以从昨天不持股转移过来，表示从昨天到今天什么都不操作，这一点是显然的
     * dp[i - 1][1] + prices[i]：昨天持股，就在索引为 i 的这一天，我卖出了股票，状态由 1 变成了 0，此时卖出股票，因此加上这一天的股价
     *
     * @param prices
     * @return
     */
    public int maxProfitRe2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 动态规划2 时间复杂度O(N) 空间复杂度为O(N) N表示数组长度
     * 在 动态规划1 中增加状态 0-不进行任何操作 1-用户执行了一次买入操作 2-用户执行了一次卖出操作
     * 状态转移方程
     * dp[i][0] 永远等于 0
     * dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
     * dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i])
     * @param prices
     * @return
     */
    public int maxProfitRe3(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    /**
     * 动态规划3  时间复杂度O(N) 空间复杂度为O(1) N表示数组长度
     * 基于动态规划1 进行状态压缩
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    /**
     * 差分数组 时间复杂度O(N) 空间复杂度为O(N) N表示数组长度
     * 差分数组的连续子区间和的值，就正好是原始股价数组进行一次交易的差价
     * 算出前后两天的差 diff[i] = prices[i] - prices[i - 1]
     * 可以得到连续多天之间的差为dp[i] = max(diff[i], dp[i - 1] + diff[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int[] dp = new int[len - 1];
        dp[0] = diff[0];
        for (int i = 1; i < len - 1; i++) {
            dp[i] = Math.max(diff[i], dp[i - 1] + diff[i]);
        }

        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}