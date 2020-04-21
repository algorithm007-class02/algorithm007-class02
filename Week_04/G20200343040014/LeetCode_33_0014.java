class Solution {
    public int search(int[] nums, int target) {
        // 1. 二分查找
        // 2. 判断二分查找条件时，新增对旋转数组的判断
        // 3. 其余参考二分查找模板
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] >= nums[left]){ //如果左边有序，先进入左边
                if (target >= nums[left] && target < nums[mid]){//如果左边有序部分的最小和最大能包含target，那么结果肯定在左边。
                    right = mid -1;//向左查找
                }else
                {
                    left = mid +1; //向右查找
                }
            }else{//如果右边有序，先进入右边
                if(target > nums[mid] && target <= nums[right]){//如果右侧有序部分的最小和最大能包含target，那么结果肯定在右边。
                    left = mid +1; //向右查找
                }else
                {
                    right = mid -1;//向左查找
                }
            }
        }
        return -1;
    }
}