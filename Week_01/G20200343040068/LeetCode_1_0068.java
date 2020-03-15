class LeetCode_1_0068 {

    //类似moveZeroes, j指向下一个不重复数字的位置，i指针往后走
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;

    }
}