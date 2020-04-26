class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        /*
        *   1.暴力  枚举所有的子序列
        *   2.DP
        *    a: 分治（子问题） max_sum(i) = max(max_sum(i-1),0)+nums[i]
        *    b: 状态定义 f[i]  表示以i为结尾的子序列的最大值
        *    c: 转移方程 f[i] = max(f[i-1],0)+nums[i]
        */
        
        //int n = nums.size();
        //int dp[n];
        //dp[0] = nums[0];
        //int ans = dp[0];
        int ans = INT_MIN;
        int a = 0;
        int b = 0;
        for(int i=0;i<nums.size();i++){
            //dp[i] = max(dp[i-1],0)+nums[i];
            //ans = max(ans,dp[i]);
            b = max(a,0)+nums[i];
            a = b;
            ans = max(ans,b);
        }
        
        return ans;
    }
};