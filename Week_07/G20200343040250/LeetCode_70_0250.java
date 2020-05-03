class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2, res = 0;
        for (int i = 2; i < n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
