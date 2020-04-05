class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) throw new RuntimeException(nums is empty);
        int start = 0, end = len - 1;

        while (start < end) {
            int mid = (start + end)  1;
            if (nums[mid] <=  nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
