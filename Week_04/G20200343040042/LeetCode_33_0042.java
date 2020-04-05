package com.yequan.leetcode.algorithm.search.BinarySearch.search_33;

/**
 * //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * //
 * // ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * //
 * // 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * //
 * // 你可以假设数组中不存在重复的元素。
 * //
 * // 你的算法时间复杂度必须是 O(log n) 级别。
 * //
 * // 示例 1:
 * //
 * // 输入: nums = [4,5,6,7,0,1,2], target = 0
 * //输出: 4
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: nums = [4,5,6,7,0,1,2], target = 3
 * //输出: -1
 * // Related Topics 数组 二分查找
 *
 * @author : Administrator
 * @date : 2020/4/5
 */
public class Search {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {1, 3};
        Search search = new Search();
        int res = search.search2(nums3, 3);
        System.out.println(res);
    }

    /**
     * 二分查找
     * 这类数组可以分为两种
     * 当mid落在有序的半段中:  只需要考虑target是否在该区间内
     * 当mid落在旋转元素即无序的半段:  则考虑target是否在该区间之外
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //如果前半段有序
            if (nums[left] <= nums[mid]) {
                //target在[left,mid]区间内
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    //target不在[left,target]区间内
                    left = mid + 1;
                }
                //前半段包含了旋转元素
            } else {
                //target不在[left,mid]区间内
                if (target < nums[left] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return helper(left, right, nums, target);
    }

    private int helper(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (target == nums[mid]) {
            return mid;
        }
        //有序的区间
        if (nums[left] <= nums[mid]) {
            //target在有序的区间内
            if (target >= nums[left] && target <= nums[mid]) {
                return helper(left, mid - 1, nums, target);
            } else {
                return helper(mid + 1, right, nums, target);
            }
            //无序的区间
        } else {
            //target不在该区间内
            if (target < nums[left] && target > nums[mid]) {
                return helper(mid + 1, right, nums, target);
            } else {
                return helper(left, mid - 1, nums, target);
            }
        }
    }

}
