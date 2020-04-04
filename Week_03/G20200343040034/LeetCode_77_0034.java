package com.alang.learn.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/***
 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combinations
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_77_0034 {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n <= 0 || k > n) return res;
            backtrack(res, new LinkedList<>(), 0, n, k);
            return res;
        }

        public void backtrack(List<List<Integer>> res, LinkedList<Integer> temp, int start, int n, int count) {
            if (temp.size() == count) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start + 1; i <= n; i++) {
                temp.add(i);
                backtrack(res, temp, i, n, count);
                temp.removeLast();
            }
        }
    }
}
