package com.algorithm.firstWeek;

/**
 * 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        moveZeros(nums);
//        myMoveZeroes(nums);
    }

    private static void moveZeros(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void myMoveZeroes(int[] nums) {
        for(int i = 0, j = i + 1; j < nums.length; ) {
            if(nums[i] != 0) {
                i++;
                j = i + 1;
            }else if(nums[j] != 0 && 0 == nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i++;
                j = i + 1;
            }else {
                j++;
            }
        }

        for(int i : nums) {
            System.out.print(i  + " ,");
        }
    }
}
