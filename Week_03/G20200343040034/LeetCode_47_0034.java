package com.alang.learn.week3;

import java.util.*;

/***
 给定一个可包含重复数字的序列，返回所有不重复的全排列。

 示例:

 输入: [1,1,2]
 输出:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_47_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(solution.permuteUnique(nums));
    }

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            backTrace(nums, visited, res, new LinkedList<>());
            return res;
        }

        public void backTrace(int[] nums, boolean[] visited, List<List<Integer>> res, LinkedList<Integer> temp) {
            if (temp.size() == nums.length) res.add(new LinkedList<>(temp));
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp.add(nums[i]);
                    backTrace(nums, visited, res, temp);
                    visited[i] = false;
                    temp.removeLast();
                    while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
                }
            }
        }
    }
}
