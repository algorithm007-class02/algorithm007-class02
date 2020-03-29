/**
 * 组合
 */
public class LeetCode_77_0222 {
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 回溯法
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        traversalNum(new LinkedList<Integer>(), 1, n ,k);
        return res;
    }

    /**
     * 递归调用
     * 遍历从 start到 n的所有整数
     * 将整数 i 添加到现有组合 curr中
     * 继续向组合中添加更多整数
     * 将 i 从 curr中移除，实现回溯。
     * @param curr 需添加列表
     * @param start 开始数字
     * @param n
     * @param k
     */
    private void traversalNum(LinkedList<Integer> curr, int start, int n, int k) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
        }
        for (int i = start; i < n + 1; i++) {
            curr.add(i);
            traversalNum(curr, i + 1, n ,k);
            curr.removeLast();
        }
    }

}