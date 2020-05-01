class Solution {


    /**
     * 暴力递归
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs_1(int n) {
        if(n <= 2) return n;
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;

        for(int i = 3; i < n + 1; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }

    /**
     * 斐波那契数
     * @param n
     * @return
     */
    public int climbStairs_2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}