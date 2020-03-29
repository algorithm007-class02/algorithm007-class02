//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_77_0206 {
    private List<List<Integer>> res = new ArrayList<>();

    //组合
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            return res;
        }
        List<Integer> track = new ArrayList<>();
        backTrack(n, k, 1, track);
        return res;
    }

    private void backTrack(int n, int k, int start, List<Integer> track) {
        if (k == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(n, k, i+1, track);
            track.remove(track.size() - 1);
        }


    }

    public static void main(String[] args) {
        LeetCode_77_0206 source = new LeetCode_77_0206();
        List<List<Integer>> result = source.combine(4,2);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
