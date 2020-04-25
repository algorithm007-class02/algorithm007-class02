class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int res = 0;
        if (prices.size() == 0) return 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
};