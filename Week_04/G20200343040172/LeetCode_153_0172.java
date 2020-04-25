package week04.g20200343040172;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * LeetCode-153 Find minimum in rotated sorted arrayl 寻找旋转排序数组中的最小值
 */
public class LeetCode_153_0172 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        // nums[left] < nums[right]说明数组为有序(从小到大排序)的，所以直接返回nums[0]即可
        if (nums[left] < nums[right]) {
            return nums[0];
        }
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
