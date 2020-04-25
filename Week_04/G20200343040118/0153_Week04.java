class Solution {
    public int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while( begin > end){
            int mid = (begin + end)/2;
            if(nums[mid] > nums[end]){
                begin = mid;
            }else{
                end = mid;
            }
        }
        return nums[begin];
    }
}