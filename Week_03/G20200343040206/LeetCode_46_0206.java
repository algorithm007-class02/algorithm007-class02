//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_46_0206 {
    private List<List<Integer>> res = new ArrayList<>();

    //排列
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        LinkedList<Integer> track = new LinkedList<>();

        backTrack(nums, track);

        return res;

    }

    private void backTrack(int[]nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);

            backTrack(nums, track);

            track.removeLast();
        }



    }





    public static void main(String[] args) {
        LeetCode_46_0206 source = new LeetCode_46_0206();
        List<List<Integer>> result = source.permute(new int[]{1,2,3});
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
