class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(dp[j],maxVal);
                }
            }
            dp[i] = maxVal + 1;
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}