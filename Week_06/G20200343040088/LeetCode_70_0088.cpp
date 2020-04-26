class Solution {
public:
    int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 1;
        int b = 2;
        int ret = 0;
        for (int i = 3; i <= n; ++i) {
            ret = a + b;
            b = a;
            a = ret;
        }
        return ret;
    }
};