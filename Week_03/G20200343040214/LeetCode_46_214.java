package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {
    // TODO 理解和死记硬背 回溯法
    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3, 4 }).toString());
    }

    private static void backTrack(int n, List<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n)
            output.add(new ArrayList<>(nums));
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backTrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> nums_lst = new ArrayList<>();
        for (int num : nums) {
            nums_lst.add(num);
        }
        int n = nums.length;
        backTrack(n, nums_lst, output, 0);
        return output;
    }

    //
    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        List<List<Integer>> list = new ArrayList<>();
        permute(0, nums, list);
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 全排列
     * 
     * @param idx 正在排列第idx个数值
     */
    private void permute(int idx, int[] nums, List<List<Integer>> list) {
        if (idx == nums.length) {
            List<Integer> data = new ArrayList<>();
            for (int num : nums) {
                data.add(num);
            }
            list.add(data);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            permute(idx + 1, nums, list);
            swap(nums, i, idx);
        }
    }
}
