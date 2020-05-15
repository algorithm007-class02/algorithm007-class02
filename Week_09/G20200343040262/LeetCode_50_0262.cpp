/*
 * @lc app=leetcode.cn id=50 lang=cpp
 *
 * [50] Pow(x, n)
 */

// @lc code=start\
// 快速幂 + 迭代
// 快速幂即每次平方，加速至Ologn，x -> x2 -> x4 -> ... -> x32
class Solution {
public:
    double quickMul(double x, long long N) {
        double res = 1.0;
        // 奇次幂需计算的额外的x，单独拎出来
        double odd_x = x;
        while (N > 0) {
            // 刚好是转化为二进制位时，为1,则乘该位置对应的数
            if (N % 2 == 1) {
                res *= odd_x;
            }
            odd_x *= odd_x;
            N /= 2;
        }
        return res;
    }
    double myPow(double x, int n) {
        long long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
};
// @lc code=end
