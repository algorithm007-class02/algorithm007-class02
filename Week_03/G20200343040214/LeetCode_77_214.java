package level2;

import java.util.*;

public class Solution77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2).toString());
    }

    public static List<List<Integer>> combine(int n, int k) {
        // C(m,n)=C(m-1,n)+C(m-1,n-1)
        // 不考虑排序
        if (k > n || k == 0) {
            return new ArrayList<>();
        }
        if (k == 1) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                lists.add(new ArrayList<>(Collections.singletonList(i)));
            }
            return lists;
        }
        if (k == n) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                list.add(i);
            }
            lists.add(list);
            return lists;
        }
        // C(n, k) = C(n-1, k-1) + C(n-1, k)
        List<List<Integer>> answer = combine(n - 1, k);
        for (List<Integer> item : combine(n - 1, k - 1)) {
            System.out.println("-->" + item.toString());
            item.add(n);
            answer.add(item);
        }
        return answer;
    }

    // TODO 理解回溯法
    List<List<Integer>> output = new ArrayList<>();
    int n, k;

    public void backTrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
        }
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backTrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(1, new LinkedList<>());
        return output;
    }

    //
    private void getAns(int start, int n, int k, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            getAns(i + 1, n, k, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    //
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();
        DFS(res, ele, k, 1, n);
        return res;
    }

    public void DFS(List<List<Integer>> res, List<Integer> ele, int k, int start, int n) {
        if (k == 0) {
            res.add(new ArrayList<>(ele));
            return;
        }
        if (k > n - start + 1)
            return;
        for (int i = start; i <= n; i++) {
            ele.add(i);
            DFS(res, ele, k - 1, i + 1, n);
            ele.remove(ele.size() - 1);
        }
    }

    //
    public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, res, path);
        return res;
    }

    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> path) {
        if (k == 0)
            res.add(new ArrayList<>(path));
        for (int i = n; i > 0; --i) {
            if (i < k)
                break;
            else {
                path.add(i);
                dfs(i - 1, k - 1, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
