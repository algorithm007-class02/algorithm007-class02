给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 

 注意 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

 示例 1 

 输入 [2,4,1], k = 2
输出 2
解释 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 

 示例 2 

 输入 [3,2,6,5,0,3], k = 2
输出 7
解释 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
。
 
 Related Topics 动态规划


 k=prices.length2时才有约束力
 状态转移框架


 注意处理i==0的代码块
 注意int[][][] status = new int[prices.length][k+1][2];中的 k+1;
 注意 return status[prices.length-1][k][0];中的 prices.length-1
 j=k

leetcode submit region begin(Prohibit modification and deletion)

class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length=0  k=0){
            return 0;
        }
        if (k  prices.length2){
            return PInfinity(prices);
        }else {
            int[][][] status = new int[prices.length][k+1][2];
            for (int i=0; iprices.length; i++){
                for (int j=1; j=k; j++){
                    if (i==0){
                        atttention
                        status[i][j][0]=0;
                        status[i][j][1]=-prices[0];
                        continue;
                    }
                    status[i][j][0]=Math.max(status[i-1][j][0], status[i-1][j][1]+prices[i]);
                    status[i][j][1]=Math.max(status[i-1][j][1], status[i-1][j-1][0]-prices[i]);
                }
            }
            return status[prices.length-1][k][0];
        }
    }

    public int PInfinity(int[] prices){
        int maxIncome = 0;
        int lowestPrice = 0;
        for (int i=01; iprices.length; i++){
            if (prices[i]-prices[i-1]0){
                maxIncome+=prices[i]-prices[i-1];
            }
        }
        return maxIncome;
    }
}

  时间复杂度为O(n^2),空间复杂度为O(n^3)
  耗时13ms（23%），使用内存41.8M（6.25%）
leetcode submit region end(Prohibit modification and deletion)
