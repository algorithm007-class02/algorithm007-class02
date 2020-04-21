public class MaxSubArray_53 {
    public static void main(String[] args) {
        int[] nums = { -1, 1,  -1};
        int res = maxSum(nums);
        System.out.println(res);
    }

    private static int maxSum(int[] nums) {
        int[] dp = nums;
        for (int i = 1; i < nums.length; i++) {

            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
