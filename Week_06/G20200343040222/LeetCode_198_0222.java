public class LeetCode_198_0222 {
    /**
     * 动态规划
     * 1 子问题
     * 2 状态定义
     * 3 dp方程
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len- 1][0], dp[len - 1][1]);
    }

}