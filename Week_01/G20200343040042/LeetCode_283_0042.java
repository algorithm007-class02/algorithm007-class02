package com.yequan.leetcode.array.movezeros_283;

/**
 * //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * //
 * // 示例:
 * //
 * // 输入: [0,1,0,3,12]
 * //输出: [1,3,12,0,0]
 * //
 * // 说明:
 * //
 * //
 * // 必须在原数组上操作，不能拷贝额外的数组。
 * // 尽量减少操作次数。
 *
 * @author : Administrator
 * @date : 2020/3/8
 */
public class MoveZeroes {

    /**
     * 算法思想:
     * 将不为零的数往前移动,使用一个指针index记录最近一次非零数的位置,最后将最后的数都置为零
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //移动不为0的值到数组前边,并记录下标
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 相邻交换法
     * 遍历数组,找出相邻两个数中为0的,出现0则往后交换
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int nonzeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonzeroIndex] = nums[i];
                if (i != nonzeroIndex) {
                    nums[i] = 0;
                }
                nonzeroIndex++;
            }
        }
    }

    /**
     * 与第一种一样
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

}
