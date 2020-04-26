class Solution {
public:
/*
the main idea is that we maintain a variable which is the lowest prices before.
*/
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n<=1) return 0;

        int ans = 0;
        int presmall = prices[0];
        for(int i=1;i<n;i++){
            ans = max(ans,prices[i]-presmall);
            presmall = min(presmall,prices[i]);
        }
        return ans;
    }
};