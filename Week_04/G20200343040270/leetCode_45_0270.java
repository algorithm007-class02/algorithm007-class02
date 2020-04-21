class Solution {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int jump(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0 || nums[0] == 0) return res;
        int max = 0, end = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                ++res;
                end = max;
            }
        }
        return res;
    }
}