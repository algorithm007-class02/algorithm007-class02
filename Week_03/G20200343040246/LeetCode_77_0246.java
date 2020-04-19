package Week_03.G20200343040246;

import java.util.*;

class LeetCode_77_0246 {

    public static void main(String[] args) {
        List<List<Integer>> res = new LeetCode_77_0246().combine(4, 2);
        System.out.println(res.toString());
    }

    // 回溯 backtrack
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || n < k) return res;
		backtrack(res, new ArrayList<Integer>(), 1, n, k);
		return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> cur, int start, int n, int k) {
		if (k == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i <= n - k + 1; i++) {
			cur.add(i);
			backtrack(res, cur, i+1, n, k-1);
			cur.remove(cur.size()-1);
		}
	}
}