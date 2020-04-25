package com.yequan.leetcode.algorithm.search.BinarySearch.findMin_153;

import com.yequan.leetcode.algorithm.search.BinarySearch.findIndex.FindIndex;

import java.util.PriorityQueue;

/**
 * //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * //
 * // ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * //
 * // 请找出其中最小的元素。
 * //
 * // 你可以假设数组中不存在重复元素。
 * //
 * // 示例 1:
 * //
 * // 输入: [3,4,5,1,2]
 * //输出: 1
 * //
 * // 示例 2:
 * //
 * // 输入: [4,5,6,7,0,1,2]
 * //输出: 0
 * // Related Topics 数组 二分查找
 *
 * @author : Administrator
 * @date : 2020/4/5
 */
public class FindMin {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin2(nums));
    }

    /**
     * 小顶堆
     *
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        return queue.peek();
    }

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        if (null == nums) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[0];
        }
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
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
