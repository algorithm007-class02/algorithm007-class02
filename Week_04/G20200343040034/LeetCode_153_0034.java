package com.alang.learn.week4;

/***
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 你可以假设数组中不存在重复元素。

 示例 1:

 输入: [3,4,5,1,2]
 输出: 1
 示例 2:

 输入: [4,5,6,7,0,1,2]
 输出: 0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_153_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums));
        System.out.println(solution.findMin1(nums));
    }

    static class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                if (nums[left] <= nums[right]) return nums[left];
                if (nums[mid = (left + right) >> 1] >= nums[mid + 1]) return nums[mid + 1];
                if (nums[mid] <= nums[mid - 1]) return nums[mid];
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }

        public int findMin1(int[] arr) {
            int left = 0, right = arr.length - 1, mid = 0;
            while (left <= right) {
                if (arr[left] <= arr[right]) return arr[left];
                mid = left + ((right - left) >> 1);
                if (mid == left) return Math.min(arr[left], arr[right]);
                if (arr[mid] < arr[mid - 1]) {
                    break;
                } else if (arr[left] > arr[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return arr[mid];
        }
    }
}
