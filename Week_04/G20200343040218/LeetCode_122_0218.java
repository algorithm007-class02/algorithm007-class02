class Solution {
    public int maxProfit(int[] prices) {
        int count = 0;
        if (prices == null || prices.length < 2) {
            return count;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                count += prices[i] - prices[i - 1];
            }
        }
        return count;
    }
}