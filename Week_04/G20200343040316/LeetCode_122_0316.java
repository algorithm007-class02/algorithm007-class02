package com.wxs.algorithm1.week04;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_122_0316 {


    public int maxProfit(int[] prices) {

        int price = 0;

        for (int i = 1; i < prices.length; i++) {
           if(prices[i] > prices[i-1]){


               price+= prices[i] - prices[i -1];
           }

        }

        return price;


    }

}
