class Solution {

    /**
     * 贪心解法？,因为有个总能跳到最后一个的前提
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int jumpCount = 0;
        int maxPos = 0;
        int nextStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(i + nums[i], maxPos);
            if (i == nextStep) {
                nextStep = maxPos;
                jumpCount++;
            }
        }
        return jumpCount;
    }
}