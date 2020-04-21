class Solution {
public:
    int climbStairs(int n) {
        if (n <= 2) return n;
        int f1 = 1, f2 = 2, f3;
        for (int i = 1; i < n - 1; ++i) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
};