//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划

/*
 * 不能重复交易，只能买卖两次
 * */

/*
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
* 状态转移法
*
* i代表天数(z最大为prices.length())，k代表买卖次数(最大为K)，第三维代表状态---是否持股，1为持股，0为未持股
*
* 不去考虑三维数组如何储存，将三个维度看做"状态表示器"，新状态的值总由之前的状态变化未来（因此称为"状态转移"）
* 而新状态的计算是有规律的，我们只要根据实际情况给定最开始的"基础值"即可。
*
* 状态计算公式（这里的i,k都是在for中的循环变量，可以根据实际情况更改）
*   status[i][k][0] = Math.max(status[i-1][k][0], status[i-1][k][1]+prices[i]);
*   status[i][k][1] = Math.max(status[i-1][k-1][0]-prices[i], status[i-1][k][1]);
* 解读
* "已买卖k次且今天不持股"的当前最大收益 = "前一天就已经不持股且无操作"的累计收益 与 "已买卖k次且昨天持股并当日卖出"的累计收益 的较大值
*   (status[i-1][k][1]+prices[i]中卖出但所求的status[i][k][0]今日不持股，说明没有买进，k不变)
* "已买卖k次且今天持股"的当前最大收益 = "已买卖k-1次且不持股的昨天并当日购入股票"的累计收益 与"昨天就已经持股且无操作"的累计收益 的较大值
*   (因为买进,所以(k-1)+1)
*
* 对于该题，设置"基础值"为（因为 i从0开始,k从1开始）
*
* 最后返回
*   return status[prices.length][maxk][0];
* 可以改写为
*   return status[i][k][0];
* 因为最后不再持股才能受益最大化，所以返回[0];
*
* 另注：因为[714]中Integer.MIN_VALUE问题，这里初始化为-prices[0]
* */

//leetcode submit region begin(Prohibit modification and deletion)

class Solution123 {
    public int maxProfit(int[] prices) {
        /*
        * 未优化的状态转移*/
//        int maxk = 2;
//        int[][][] status = new int[prices.length][maxk][2];
//        for (int i=0; i<prices.length; i++){
//            //注意k从1开始
//            for (int k=1; k<maxk; k++){
//                if (i==0){
//                    //i=0对应数值进入时需要以下值计算
//                    //数组越界，这里只做逻辑演示
//                    //status[0][1][0] = Math.max(status[-1][1][0], status[-1][1][1]+prices[0]);
//                    //status[0][1][1] = Math.max(status[-1][0][0]-prices[0], status[-1][1][1]);
//
//                    //status[0][2][0] = Math.max(status[-1][2][0], status[-1][2][1]+prices[0]);
//                    //status[0][2][1] = Math.max(status[-1][1][0]-prices[0], status[-1][2][1]);
//                    //需要
//                    status[-1][1][0]=0;
//                    status[-1][1][1]=Integer.MIN_VALUE;
//                    status[-1][0][0]=0;
//
//                    status[-1][2][0]=0;
//                    status[-1][2][1]=Integer.MIN_VALUE;
//                }
//                status[i][k][0] = Math.max(status[i-1][k][0], status[i-1][k][1]+prices[i]);
//                status[i][k][1] = Math.max(status[i-1][k-1][0]-prices[i], status[i-1][k][1]);
//            }
//        }
//        return status[prices.length][maxk][0];
        /*
        * 优化后的实际代码
        * 将i和k直接定位最大值，循环覆盖，只讨论状态
        * 还要加上极端情况，如[]，不能直接prices[0]*/
        if (prices.length<=0){
            return 0;
        }
        int status_i00=0;
        int status_i10=0;
        int status_i11=-prices[0];
        int status_i20=0;
        int status_i21=-prices[0];
        for (int price : prices){
            //注意顺序,必须由未迭代的"基础值"计算，在通过循环迭代
            status_i20=Math.max(status_i20, status_i21+price);
            status_i21=Math.max(status_i10-price, status_i21);
            status_i10=Math.max(status_i10, status_i11+price);
            status_i11=Math.max(status_i11, status_i00-price);
        }
        return status_i20;
        /*
         * 时间复杂度为O(n),空间复杂度为O(5)
         * 耗时1ms（100%），使用内存39.7M（47%）*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
