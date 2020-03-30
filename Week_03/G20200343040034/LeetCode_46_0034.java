package com.alang.learn.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/***
 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_46_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.permute(nums));
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return Collections.emptyList();
            }
            ArrayList<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            return backTrack(list, new ArrayList<>(), 0, nums.length);
        }

        public List<List<Integer>> backTrack(ArrayList<Integer> nums, ArrayList<List<Integer>> result, int start, int count) {
            if (count == start) {
                result.add(new ArrayList<>(nums));
            }
            for (int i = start; i < count; i++) {
                Collections.swap(nums, start, i);
                backTrack(nums, result, start + 1, count);
                Collections.swap(nums, start, i);
            }
            return result;
        }
    }
}
