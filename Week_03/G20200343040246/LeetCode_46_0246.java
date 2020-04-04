package Week_03.G20200343040246;

import java.util.*;

class LeetCode_46_0246 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_46_0246().permute(new int[]{1,2,3}).toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, nums.length, res);
        return res;
    }

    public void backtrack(int[] nums, int depth, int len, List<List<Integer>> res) {
        if (depth == len - 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            res.add(tmp);
        }
        for (int i = depth; i < len; i++) {
            swap(nums, depth, i);
            backtrack(nums, depth + 1, len, res);
            swap(nums, depth, i);
        }
    }

    public void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}