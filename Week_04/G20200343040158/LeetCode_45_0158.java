class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j > 0; j--) {
                if (i + j >= nums.length - 1) {
                    return dp[i] + 1;
                } else if (dp[i + j] == 0) {
                    dp[i + j] = dp[i] + 1;
                } else {
                    break;
                }
            }
        }
        return 0;
    }
}