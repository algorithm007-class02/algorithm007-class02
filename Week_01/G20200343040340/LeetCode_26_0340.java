class week01 {
    /**
     * 26. 删除排序数组中的重复项
     *  将后面与前面不同种的元素提前
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        for (int q = 1; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                p++;
                nums[p] = nums[q];
            }
        }
        return p + 1;
    }
}