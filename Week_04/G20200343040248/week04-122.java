class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i< prices.length; i++){
            if(prices[i] > prices[i-1]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}

//总和所有后一天大于前一天的收益，即为最大收益