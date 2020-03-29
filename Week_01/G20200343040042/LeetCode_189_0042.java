package com.yequan.leetcode.array.rotate_189;

/**
 * //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,2,3,4,5,6,7] 和 k = 3
 * //输出: [5,6,7,1,2,3,4]
 * //解释:
 * //向右旋转 1 步: [7,1,2,3,4,5,6]
 * //向右旋转 2 步: [6,7,1,2,3,4,5]
 * //向右旋转 3 步: [5,6,7,1,2,3,4]
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: [-1,-100,3,99] 和 k = 2
 * //输出: [3,99,-1,-100]
 * //解释:
 * //向右旋转 1 步: [99,-1,-100,3]
 * //向右旋转 2 步: [3,99,-1,-100]
 * //
 * // 说明:
 * //
 * //
 * // 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * // 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @author : Administrator
 * @date : 2020/3/11
 */
public class Rotate {

    /**
     * 暴力移动法:
     * 保存最后一个数nums[length-1],每次将1-(length-1)的数依次后移一位
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k < 0) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 增加临时数组法:
     * 1.将nums数组按照 temp[(k+i)%nums.length]<---->nums[i] 存放至一个空数组中temp中
     * 2.将temp复制进nums
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * <p>
     * 基础知识:
     * 数组中每个元素的位置为:
     * 当前位置index % 数组长度
     * <p>
     * 这道算法题考察的就是对数组位置表示的应用
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k < 0) {
            return;
        }
        int[] temp = new int[nums.length];
        //1.将nums数组按照 i<---->(k+i)%nums.length 存放至一个空数组中temp中
        for (int i = 0; i < nums.length; i++) {
            temp[(k + i) % nums.length] = nums[i];
        }
        //2.将temp复制进nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * 环状替换法:
     * 算法核心: 位置i的元素,向右移动k位后的位置是(i+k),当(i+k)>=nums.length,位置将在i的前边,所以经过k次右移后,位置为 (i+k)%nums.length
     * 数组中每一个元素都经过一次这样的替换
     *
     * 复杂度
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k < 0) {
            return;
        }
        k = k % nums.length;
        /**
         * count用于记录数组中元素替换的个数
         */
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

}
