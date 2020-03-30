package com.heiko;

import javax.management.StandardEmitterMBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class LeetCode_47_0100 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        trackBack(results, current, nums, used);
        return results;
    }

    private void trackBack(List<List<Integer>> results, List<Integer> current, int[] nums,  boolean[] used) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                current.add(nums[i]);
                trackBack(results, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
