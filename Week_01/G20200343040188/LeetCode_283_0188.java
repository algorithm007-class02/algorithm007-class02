package com.leetcode.array;

public class L283MoveZeros {
    /**
     * 快慢指针方法
     */
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (i != slow) {
                nums[slow] = nums[i];
                nums[i] = 0;
            }
            slow++;
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (zeroCount == 0) {
                    continue;
                } else {
                    nums[i - zeroCount] = nums[i];
                }
            }
        }
        for (int i = 1; i <= zeroCount; i++) {
            nums[nums.length - i] = 0;
        }
    }

    public static void moveZeroes1(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }

            if (zeroCount > 0) {
                int tmp = nums[i - zeroCount];
                nums[i - zeroCount] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
