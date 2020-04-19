class Solution {
    public int maxProfit(int[] prices) {
        //后者与前者的差大于0的都是收益，相加算总收益
        int sum = 0;
        for(int i = 1;i < prices.length;i++){
            int temp = prices[i] - prices[i - 1];
            if(temp > 0){
                sum += temp;
            }
        }
        return sum;
    }
}