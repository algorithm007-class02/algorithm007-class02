package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 17:38
 * @Description:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class LeeCode_122_0226 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
