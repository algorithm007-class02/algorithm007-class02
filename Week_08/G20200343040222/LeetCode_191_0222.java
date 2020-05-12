public class LeetCode_191_0222 {

    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask <<= 1;
        }
        return res;
    }

    /**
     * 用 n & (n - 1) 将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0
     * @param n
     * @return
     */
    public int hammingWeightRe(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }

}