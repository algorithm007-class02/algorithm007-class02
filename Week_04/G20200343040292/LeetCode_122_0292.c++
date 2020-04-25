/*贪心法
时间复杂度：O(N)
空间复杂度：O(1)*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.empty())
            return 0;
             
        int max = 0;
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices[i] < prices[i+1])
                max += prices[i+1] - prices[i];
        }
        return max;
    }
};