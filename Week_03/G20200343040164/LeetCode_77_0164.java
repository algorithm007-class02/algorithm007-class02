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
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if ( n <= 0 || k <= 0 || n < k ) return result;
        find(n,k,1,new Stack<>());
        return result;
    }
    public void find(int n, int k, int index, Stack<Integer> p) {
        if (p.size() == k) {
            result.add(new ArrayList<>(p));
            return;
        }
        for ( int i = index; i <= n - ( k - p.size() ) + 1; i++ ) {
            p.push(i);
            find(n,k,i+1,p);
            p.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
