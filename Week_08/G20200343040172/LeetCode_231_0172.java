package week08.g20200343040172;

public class LeetCode_231_0172 {

    /**
     * 是否满足为2的幂关键是看二进制数字有多少个1，有且仅有一个1，一定是2的冥
     * 比如：0001，0010，0100
     */
    class Solution1 {
        public boolean isPowerOfTwo(int n) {
            return n <= 0 ? false : (n & (n - 1)) == 0 ? true : false;
        }
    }
}
