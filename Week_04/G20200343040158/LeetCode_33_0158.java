class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left+right)/2;
            double num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid] : target < nums[0] ? -Integer.MAX_VALUE : Integer.MAX_VALUE;
            if (num < target) {
                left = mid+1;
            } else if (num > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}