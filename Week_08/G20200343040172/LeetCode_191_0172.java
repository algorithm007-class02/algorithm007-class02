package week08.g20200343040172;

public class LeetCode_191_0172 {
    /**
     * 解法一：
     * 暴力法：一次for循环统计1的个数
     */

    /**
     * 解法二：
     * n初始为1，相与以后再移位
     */
    class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }

    /**
     * 解法三：
     * n = n & (n - 1)每次清零最后一位1，直至n变为0
     */
    class Solution3 {
        public int hammingWeight(int n) {
            int sum = 0;
            while (n != 0) {
                sum++;
                n &= (n - 1);
            }
            return sum;
        }
    }
}
