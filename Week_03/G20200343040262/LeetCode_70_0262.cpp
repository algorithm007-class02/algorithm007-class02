class Solution {
public:
    int climbStairs(int n) {//转化为斐波那契数列，到达第n层台阶，只能从第n-1层跨一步或者从第n-2层跨两步，且这两种方式不重复
        int f1 = 1,f2 = 2,f3;
        if (n <= 2) return n;
        for (int i = 1; i < n - 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
};