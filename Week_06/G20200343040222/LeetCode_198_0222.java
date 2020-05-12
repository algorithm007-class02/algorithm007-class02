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
        int curr = 0;
        int pre = 0;
        for (int num : nums) {
            int temp = curr;
            curr = Math.max(pre + num, curr);
            pre = temp;
        }
        return curr;
    }

}