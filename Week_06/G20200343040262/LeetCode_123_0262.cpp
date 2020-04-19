class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int oneBuyOneSell = 0;
        int twoBuyTwoSell = 0;
        int oneBuy = INT_MAX;
        int twoBuy = INT_MAX;
        for (int i = 0; i < prices.size(); ++i) {
            int p = prices[i];
            oneBuy = min(oneBuy, p);//第一次买进的最小成本
            oneBuyOneSell = max(oneBuyOneSell, p - oneBuy);//第一次卖出的最大利润
            twoBuy = min(twoBuy, p - oneBuyOneSell);//第二次买进的最小成本（减去第一次的利润）
            twoBuyTwoSell = max(twoBuyTwoSell, p - twoBuy);//第二次卖出的最大利润
        }
        return twoBuyTwoSell;
    }
};