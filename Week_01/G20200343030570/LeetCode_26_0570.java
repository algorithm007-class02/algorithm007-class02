class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums.length;
        }
        int i = 0, j = 1;
        while(j < nums.length) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            ++j;
        }

        return i + 1;

    }
}