//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划

import java.util.Arrays;

/**
* 这个题目只允许在给定的"股市"中进行一次买入和卖出*/

//leetcode submit region begin(Prohibit modification and deletion)

class Solution121 {
    public int maxProfit(int[] prices) {
        /**
        * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/hen-jing-dian-de-tan-xin-suan-fa-by-pendygg/
         * 贪心，每次选择都找最优，既然一次买卖要在最低价处买入，
         * 那么我们就先假设（维护）一个最低价
         * 然后向后推进，每次进一个新价格
         * 如果下次选择中有更低的价格，就更新最低价，
         * 如果新价格大于最低价，那么就计算差值，收益变大就更新收益，直到最后
         * 注: int MaxIncome不能初始化为Integer.MIN_VALUE，因为prices[]如果是递减的话，这种算法不会更新MaxIncome*/
        int lowestPrice = Integer.MAX_VALUE;
        int MaxIncome = 0;
        for (int p : prices){
            if (p<lowestPrice){
                lowestPrice=p;
            }else {
                MaxIncome = Math.max(MaxIncome, p-lowestPrice);
            }
        }
        return MaxIncome;
        /*
         * 时间复杂度为O(n),空间复杂度为O(2)
         * 耗时1ms（99），使用内存39.9M（5%）*/


        /**自己的方法二
         * 既然只买卖一次，那么就以"最低价买入，最高价卖出即可"
         * 将问题转换为寻找最低与最高,但"高价"的索引要在"低价"之后
         * 因此也不能使用 “先"标定"最低价，在标定最高价的方法” ，先标最高价亦不行
         * emmm看题解吧*/



        /**自己的方法一，暴力
         * 开辟一个数组，让计算机帮我计算每一天入股的最大收益，最后在取出其最大值
         * (不用数组，直接变量覆盖)，果然很慢*/
//        int MaxIncome=0;
//
//        for (int i=0; i<prices.length-1; i++){
//            for (int j=i+1; j<prices.length; j++){
//                if (MaxIncome<(prices[j]-prices[i])){
//                    MaxIncome=(prices[j]-prices[i]);
//                }
//            }
//        }
//        return MaxIncome;
        /*
         * 时间复杂度为O(n^2),空间复杂度为O(1)
         * 耗时281ms（17%），使用内存40.1M（5%）*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
