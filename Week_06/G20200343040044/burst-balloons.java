package 第五周;

class Solution {
    public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    
    int[][] dp = new int[nums.length][nums.length];
    for (int len = 1; len <= nums.length; len++) {
        for (int start = 0; start <= nums.length - len; start++) {
            int end = start + len - 1;
            for (int i = start; i <= end; i++) {
                int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                coins += i != start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.
                coins += i != end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
                dp[start][end] = Math.max(dp[start][end], coins);
            }
        }
    }
    return dp[0][nums.length - 1];
    }

    private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
    if (i < 0 || i >= nums.length) {
        return 1;
    }
    return nums[i];
    }
}