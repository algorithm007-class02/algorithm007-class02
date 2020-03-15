class Solution {
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int moveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[moveIndex] = nums[i];
                if (i != moveIndex) {
                    nums[i] = 0;
                }
                moveIndex++;
            }
        }
    }
}