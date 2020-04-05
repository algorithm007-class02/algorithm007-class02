/**
 * 二分查找步骤
 * 单调性
 * 找到边界条件
 * 对索引进行操作
 *
 */

class Solution {
    public int findMin(int[] nums) {
        int target = nums[nums.length-1];
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(nums[mid] > target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return nums[l];

    }
}