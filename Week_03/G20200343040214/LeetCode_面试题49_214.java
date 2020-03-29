package level2;

public class SolutionM49 {
    public static void main(String[] args) {

    }

    // 一个十分巧妙的动态规划问题
    // 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
    // 2.但是问题来了，我怎么确定已知前面k-1个丑数，我怎么确定第k个丑数呢
    // 3.采取用三个指针的方法，p2,p3,p5
    // 4.index2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
    // 5.我们从2*p2 3*p3 5*p5选取最小的一个数字，作为第k个丑数
    // 6.如果第K个丑数==2*p2，也就是说前面0-p2个丑数*2不可能产生比第K个丑数更大的丑数了，所以p2++
    // 7.p3,p5同理
    // 8.返回第n个丑数
    public int nthUglyNumber(int n) {
        int c2 = 0;
        int c3 = 0;
        int c5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[c2] * 2, Math.min(dp[c3] * 3, dp[c5] * 5));
            if (dp[i] == dp[c2] * 2)
                c2++;
            if (dp[i] == dp[c3] * 3)
                c3++;
            if (dp[i] == dp[c5] * 5)
                c5++;
        }
        return dp[n - 1];
    }

    private boolean isUgly(int n) {
        // 判断一个数是不是丑数
        if (n <= 0)
            return false;
        int num = n;
        while (true) {
            if (num == 1)
                return true;
            if (num == 2)
                return true;
            if (num == 3)
                return true;
            if (num == 4)
                return true;
            if (num == 5)
                return true;
            if (num == 6)
                return true;
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
    }
}
