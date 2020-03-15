/*
LeetCode
（爬楼梯）题目70描述：
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
*/

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