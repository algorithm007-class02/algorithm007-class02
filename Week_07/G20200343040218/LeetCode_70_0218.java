class Solution {
    public int climbStairs(int n) {
        int pre = 0;
        int cur = 1;
        int tmp;
        for (int i = 1; i <= n; i++) {
            tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }
        return cur;
    }
}