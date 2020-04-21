class Solution {
public:
    int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int x = 1; // x, y 储存的是中间变量 Opt[i]
        int y = 0;
        int temp = -1;
        for (int i = 2; i <= N; i++) {
            temp = x + y; // 状态转移方程
            y = x;
            x = temp;
        }

        return x;
    }
};