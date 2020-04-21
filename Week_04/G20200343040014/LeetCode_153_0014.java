class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        if (nums[left] <= nums[right]) return nums[left];
        while (left <= right){
            if (nums[left] <= nums[right]) return nums[left];
            if (right - left == 1) return nums[right]>nums[left]?nums[left]:nums[right];
            int mid = left + (right - left)/2;
            if (nums[mid -1] > nums[mid] && nums[mid] < nums[mid +1]) return nums[mid];
            if (nums[left] < nums[mid]){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}