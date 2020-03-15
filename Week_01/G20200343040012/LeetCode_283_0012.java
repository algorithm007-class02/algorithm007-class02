class Solution {

    /**
     * 直接赋值为0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int moveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != moveIndex) {
                    nums[moveIndex] = nums[i];
                    nums[i] = 0;
                }
                moveIndex++;
            }
        }
    }

    /**
     * 交换方式
     * @param nums
     */
    public void moveZeroesSecond(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
    }
}