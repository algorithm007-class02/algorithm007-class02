import java.awt.List;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backTracking(res, new LinkedList<>(), 1, n, k);
        return res;
    }
    private void backTracking(List<List<Integer>> res, List<Integer> list, int start, int n, int k){
        if(k == 0){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++){
            list.add(i);
            backTracking(res, list, i+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}
// @lc code=end

