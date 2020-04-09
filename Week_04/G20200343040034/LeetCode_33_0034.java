package com.alang.learn.week4;

/***
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4
 示例 2:

 输入: nums = [4,5,6,7,0,1,2], target = 3
 输出: -1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_33_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] >= nums[left]) {//等于是为了left = mid的时候退出循环
                    if (target >= nums[left] && nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (target <= nums[right] && target > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
