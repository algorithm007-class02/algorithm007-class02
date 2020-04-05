class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1; 
        while (left <= right) {                         // 循环的条件选为左闭右闭区间left <= right
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) {             // 注意是当中值大于等于右值时，
                left = mid + 1;                         // 将左边界移动到中值的右边
            } else {                                    // 当中值小于右值时
                right = mid;                            // 将右边界移动到中值处
            }
        }
        return nums[right];                             // 最小值返回nums[right]
    }
};
