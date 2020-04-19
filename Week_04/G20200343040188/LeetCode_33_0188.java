package com.leetcode.search.binary;

public class L33SearchRotatedArray {

    /**
     * 分类解法：
     *  先按照数组是否旋转过进行分类：
     *      没有旋转：直接走原始二分搜索
     *      有旋转：判断target在数组的前半部分还是后半部分
     *          前半部分：
     *              如果 n[mid] < target && n[mid] >= n[0]
     *                  left = n[mid] + 1
     *              else
     *                  right = n[mid] - 1
     *
     *          后半部分:
     *              if n[mid] > target && n[mid] < n[0]
     *                  right = n[mid] - 1
     *              else
     *                  left = n[mid] + 1
     *
     *  关键思路：画出数轴，分类分析
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            // 数组没有旋转
            if (nums[0] < nums[nums.length - 1]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target == nums[0]) {
                    return 0;
                }
                // target在数组的前半部分
                if (target > nums[0]) {
                    if (nums[mid] < target && nums[mid] >= nums[0]) {
                        left = mid + 1;
                    } else {
                        right = mid -1;
                    }
                } else {
                    // target在数组的后半部分
                    if (nums[mid] > target && nums[mid] < nums[0]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

            }
        }

        return -1;
    }



    /**
     * 官方解法：先找到数组的旋转点，然后分段搜索
     * @param nums
     * @return
     */
    public int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public int search2(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;

        int rotate_index = findPivot(nums);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search2(nums, 0, n - 1, target);

        if (target < nums[0])
            // search in the right side
            return search2(nums, rotate_index, n - 1, target);

        // search in the left side
        return search2(nums, 0, rotate_index, target);
    }
}

