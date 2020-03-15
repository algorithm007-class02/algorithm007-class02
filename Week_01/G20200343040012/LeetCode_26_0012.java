class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int lastIndex = 0;
        for (int next = 1; next < nums.length; next++) {
            if (nums[lastIndex] != nums[next]) {
                lastIndex++;
                nums[lastIndex] = nums[next];
            }
        }
        return lastIndex + 1;
    }
}