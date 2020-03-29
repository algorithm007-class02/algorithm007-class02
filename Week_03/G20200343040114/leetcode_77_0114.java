import java.util.LinkedList;
import java.util.List;

// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
// 输入: n = 4, k = 2
// 输出:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class Solution {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrace(1, new LinkedList<>());
        return output;
    }

    private void backTrace(int start, LinkedList<Integer> data) {
        if (data.size() == k) {
            output.add(new LinkedList<>(data));
        }
        for (int i = start; i <= n; i++) {
            data.add(i);
            backTrace(i + 1, data);
            data.removeLast();
        }
    }
}