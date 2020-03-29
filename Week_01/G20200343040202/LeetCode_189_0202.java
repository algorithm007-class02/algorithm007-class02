class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] numsCopy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums[i] = numsCopy[nums.length - k + i];
            } else {
                nums[i] = numsCopy[i - k];
            }
        }
    }
}