//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_300_0206 {

    /**
     * 最值问题，动态规划
     * dp[i]: 从头到i的子数组中，最长的上升子序列
     *
     *
     *
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int lengthOfLIS_2(int[] nums) {
        int[] tails = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = 0, end = maxLen;
            while (start < end) {
                int m = (start + end) / 2;
                if (tails[m] < nums[i]) {
                    start = m + 1;
                } else {
                    end = m;
                }
            }
            tails[start] = nums[i];
            if (maxLen == end) {
                maxLen++;
            }

        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
