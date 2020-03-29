package com.yequan.leetcode.array.twosum_1;

import com.yequan.leetcode.array.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * //
 * // 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * //
 * // 示例:
 * //
 * // 给定 nums = [2, 7, 11, 15], target = 9
 * //
 * //因为 nums[0] + nums[1] = 2 + 7 = 9
 * //所以返回 [0, 1]
 * //
 * // Related Topics 数组 哈希表
 *
 * @author : Administrator
 * @date : 2020/3/13
 */
public class TwoSum {

    /**
     * 暴力法
     * 直接两遍遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        int[] indexArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    indexArray[0] = i;
                    indexArray[1] = j;
                }
            }
        }
        return indexArray;
    }

    /**
     * 哈希表法
     * 1.遍历出所有数,存入哈希表中
     * 2.从哈希表中查
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        //key: 数值  value: 下标
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (numMap.containsKey(num) && numMap.get(num) != i) {
                return new int[]{i, numMap.get(num)};
            }
        }
        return null;
    }

    /**
     * 一遍哈希表
     * 算法基础:
     * 两数之和 = 加数1 + 加数2
     * 在遍历数组过程中,获取nums[i]为加数1,然后去找加数2,没有找到加数2,则将加数1存入哈希表中,
     * 没找到的原因:1,还没遍历到加数2,当遍历到加数2时,则找加数1     2,根本就没有符合条件的数
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        //key: 数值  value: 下标
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (numMap.containsKey(num)) {
                return new int[]{i, numMap.get(num)};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}
