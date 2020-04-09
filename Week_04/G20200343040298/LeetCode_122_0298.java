//贪心算法
//由于该情景下的子问题规模足够小可以直接贪心求得最优解

class Solution {
    public int maxProfit(int[] prices) {
        int total=0;
        for (int i = 0; i <prices[i] ; i++) {
            if(prices[i+1]>prices[i]){
                total += prices[i+1] - prices[i];
            }
        }
        return total;
    }
}