class Solution {
    public void rotate(int[] nums, int k) {
        // 使用反转法
        int length = nums.length;

        k %= length;
        reverse(nums, 0 , length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}