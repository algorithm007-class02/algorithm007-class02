class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        
        if (nums.size() == 1) return nums[0];

        vector<vector<int>> dp(nums.size(), vector<int>(2));
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.size(); ++i) {
            dp[i][0] = max(dp[i-1][1], dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return max(dp[nums.size()-1][0], dp[nums.size()-1][1]);
    }
};
// 1. 分治， 重复子问题
// 当 i 的时候， f(i-1)[1] + 0 , f(i-1)[0] + nums[i];

// 2. 定义状态
// 偷与不偷

// 3. 状态转移方程


class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        
        if (nums.size() == 1) return nums[0];

        vector<int> dp = nums;
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        int ret = max(dp[0], dp[1]);

        for (int i = 2; i < nums.size(); ++i) {
            dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
            ret = max(ret, dp[i]);
        }

        return ret;
    }
};
// 1. 分治， 重复子问题

// 2. 定义状态
// f(i) 当前最大

// 3. 状态转移方程
// f(i) = max(先前最大， 前一个最大 + nums[i])