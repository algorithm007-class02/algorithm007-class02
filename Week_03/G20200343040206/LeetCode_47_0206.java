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
// Related Topics 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_47_0206 {
    private List<List<Integer>> res = new ArrayList<>();

    //组合(+去重)
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] falg = new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();

        backTrack(nums, 0,  track, falg);

        return res;
    }

    private void backTrack(int[] nums, int length, LinkedList<Integer> track, boolean[] flag) {
        if (nums.length == length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (i>0 && nums[i-1] == nums[i] && flag[i-1] == false){
                continue;
            }

            track.add(nums[i]);
            flag[i]=true;

            backTrack(nums, length+1, track, flag);

            track.removeLast();

            flag[i]=false;
        }


    }





    public static void main(String[] args) {
        LeetCode_47_0206 source = new LeetCode_47_0206();
        List<List<Integer>> result = source.permuteUnique(new int[]{1,1,2});
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
