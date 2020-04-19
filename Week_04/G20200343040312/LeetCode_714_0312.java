//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 示例 1: 
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 
//
// 注意: 
//
// 
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// 
// Related Topics 贪心算法 数组 动态规划

/*
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
* 无限次的情况与k=n的情况相等，或者说倒过来更为贴切
* 意思是直接忽略k的改变
*
* 原模板为
*   status[i][k][0]=Math.max(status[i-1][k][0], status[i-1][k][1]+price);
*   status[i][k][1]=Math.max(status[i-1][k-1][0]-price, status[i-1][k][1])
*
* 注；
*   有测试用例得，"一对"买卖会产生一个fee
*   https://blog.csdn.net/yangchao0123live/article/details/70185915
*   int status_i1=Integer.MIN_VALUE;会有隐患
*   因为
*   Integer.MIN_VALUE-1=Integer.MAX_VALUE
*   Integer.MAX_VALUE+1=Integer.MIN_VALUE
*   故这里设为-prices[0];
* */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int status_i0=0;
        int status_i1=-prices[0];
        for (int i=0; i<prices.length; i++){
            status_i0=Math.max(status_i0, status_i1+prices[i]-fee);
            status_i1=Math.max(status_i0-prices[i], status_i1);
        }
        return status_i0;
    }
    /*
     * 时间复杂度为O(n),空间复杂度为O(2)
     * 耗时5ms（84%），使用内存49M（100%）*/
}
//leetcode submit region end(Prohibit modification and deletion)
