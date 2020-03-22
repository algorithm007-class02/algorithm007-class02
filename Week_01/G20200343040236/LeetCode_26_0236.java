class LeetCode_26_0236 {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] == nums[q]) {
                q++;
            } else {
                nums[p + 1] = nums[q];
                p++;
            }
        }
        return p + 1;
    }
}