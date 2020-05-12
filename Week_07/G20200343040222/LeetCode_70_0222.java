public class LeetCode_70_0222 {

    /**
     * 进行剪枝
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int res1;
        if (map.containsKey(n - 1)) {
            res1 = map.get(n - 1);
        } else {
            res1 = climbStairs(n - 1);
            map.put(n - 1, res1);
        }
        int res2;
        if (map.containsKey(n - 2)) {
            res2 = map.get(n - 2);
        } else {
            res2 = climbStairs(n -2);
            map.put(n - 2, res2);
        }
        return res1 + res2;
    }
}