class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size(), ans = 0;
        vector<int> dp(n, 1);
        for(int i = 0; i < n; ++i){
            for(int j = i - 1; j >= 0; --j){
                if(nums[j] >= nums[i]) continue;
                dp[i] = std::max(dp[i], dp[j] + 1);
            }
            ans = std::max(dp[i], ans);
        }
        return ans;
    }
};
