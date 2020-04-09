package week04.g20200343040172;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * LeetCode-33 Search in rotated sorted array  搜索旋转排序数组
 */
public class LeetCode_33_0172 {
    /**
     * 使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序，注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                // target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { //前半部分无序
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
