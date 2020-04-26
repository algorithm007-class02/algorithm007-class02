//记录【今天之前买入的最小值】
//计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
//比较【每天的最大获利】，取最大值即可
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if (n <= 1) return 0;
        int min_price = prices[0], max_profit = 0;
        for (int i = 1; i < n; ++i) {
            max_profit = max(max_profit, prices[i] - min_price);
            min_price = min(min_price, prices[i]);
        }
        return max_profit;
    }
};