package level2;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public static void main(String[] args) {
        List<List<Integer>> list = subsets(new int[] { 1, 2, 3 });
        System.out.println(list.toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        // TODO 多回忆此种解法的妙处 新元素和上一个元素的每个序列组成的组成的新序列都是新的序列， 加入加过中，注意保留老的序列
        //
        //
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0)
            return res;
        res.add(new ArrayList<>());
        for (int num : nums) {
            // 每个新元素的时候都新开一个序列 存储当前的新元素和老结果中的
            // 每个序列组成的新序列，此时注意要保留老结果中的每一个序列，所以需要复制
            List<List<Integer>> new_subsets = new ArrayList<>();
            for (List<Integer> set : res) {
                List<Integer> nset = new ArrayList<>(set);
                // 复制一份老的序列来组成新的序列
                nset.add(num);
                new_subsets.add(nset);
            }
            res.addAll(new_subsets);
        }
        return res;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0)
            return res;
        recursion(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void recursion(List<List<Integer>> res, List<Integer> levels, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(levels));
            return;
        }
        // 给分定 n 个 格子 每个格子的元素 可选可不选
        // 不选 index 的元素
        recursion(res, new ArrayList<>(levels), nums, index + 1);
        // 选 index 的元素
        levels.add(nums[index]);
        recursion(res, new ArrayList<>(levels), nums, index + 1);
        // levels.remove(levels.size() -1); 这里 如果每次向下层的levels 是上一级的则需要移除最后添加的元素

    }
}
