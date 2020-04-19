class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                mid = nums[mid];
                right = mid - 1;
            }
        }
        return min;
    }
//    public int findMin(int[] nums) {
//
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left < right) {
//            int mid = (left + right) / 2;
//
//            if (nums[right] < nums[mid]){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
//        }
//        return nums[left];
//    }
//    public int findMin(int[] nums) {
//        int min = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            min = Math.min(nums[i],min);
//        }
//        return min;
//    }
//    public int findMin(int[] nums) {
//
//        Arrays.sort(nums);
//        return nums[0];
//    }
}