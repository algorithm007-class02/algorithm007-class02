//编写一个程序，找出第 n 个丑数。
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
// Related Topics 堆 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_264_0206 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = ugly[++index2] * 2;
            }
            if (factor3 == min) {
                factor3 = ugly[++index3] * 3;
            }
            if (factor5 == min) {
                factor5 = ugly[++index5] * 5;
            }
        }
        return ugly[n - 1];
    }

    //更精简的写法
    public int nthUglyNumber_2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(ugly[index2]*2, ugly[index3]*3), ugly[index5]*5);
            if (ugly[i] == ugly[index2]*2) {
                index2++;
            }
            if (ugly[i] == ugly[index3]*3) {
               index3++;
            }
            if (ugly[i] == ugly[index5]*5) {
               index5++;
            }
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        LeetCode_264_0206 source = new LeetCode_264_0206();
        System.out.println(source.nthUglyNumber_2(15));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
