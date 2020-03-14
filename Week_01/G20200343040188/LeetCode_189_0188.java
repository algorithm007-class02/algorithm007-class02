package com.leetcode.array;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class L189RotateArray {
    /**
     * 辅助数组法： 时间复杂度O(n), 空间复杂度O(n)
     */
    public void rotate1(int[] nums, int k) {
        int tmp[] = new int[nums.length];
        for (int i = 0; i < nums.length -k ; i++) {
            tmp[k+i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - k + i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }

    /**
     * 三次翻转法
     */
    public void rotate(int[] nums, int k) {
        // 快速处理边界场景
        if (nums.length <= 1) {
            return;
        }
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }

        int[] heads = new int[]{0, 0, k};
        int[] tails = new int[]{nums.length - 1, k - 1, nums.length - 1};
        /*
            1. 第一次反转整个数组：(head, tail) = (0, nums.lenght-1)
            2. 第二次反转数值前部: (head, tail) = (0, k-1)
            3. 第三次反转数值后部: (head, tail) = (k, nums.length-1)
         */
        for (int i = 0; i < heads.length; i++) {
            int head = heads[i];
            int tail = tails[i];

            while (head < tail) {
                swap(nums, head, tail);
                head++;
                tail--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
