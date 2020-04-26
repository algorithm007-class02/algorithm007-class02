class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n<=1) return 0;

        int maxprofit = 0;
        for(int i=0;i<n-1;i++){
            maxprofit += prices[i]<prices[i+1]?prices[i+1]-prices[i]:0;
        }
        return maxprofit;
    }
};