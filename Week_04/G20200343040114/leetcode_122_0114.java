/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * algorithms
 * Easy (58.18%)
 * Likes:    670
 * Dislikes: 0
 * Total Accepted:    146.4K
 * Total Submissions: 248.3K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
 * 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[] cash = new int[len];
        int[] stock = new int[len];
        // cash 表示当前手持现金时能获得的收益， stock 表示当前手持股票时能获得的收益
        cash[0] = 0;
        stock[0] = -prices[0];
        // 因为 i - 1 >= 0，所以 i 从 1 开始遍历
        for (int i = 1; i < len; i++) {
            // 当前手持股票卖出，用来表示手持现金可以获得的收益
            cash[i] = Math.max(cash[i - 1], stock[i - 1] + prices[i]);
            // 当前手持现金去买股票，用来表示手持股票可以获取的收益
            stock[i] = Math.max(stock[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[len - 1];
    }
}
// @lc code=end
