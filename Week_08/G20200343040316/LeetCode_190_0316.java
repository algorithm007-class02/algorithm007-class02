package com.wxs.algorithm1.week08;

/**
 * 类描述  ：
 *
 *
 * 1. 将 x 最右边的 n 位清零:x & (~0 << n)
 * 2. 获取 x 的第 n 位值(0 或者 1): (x >> n) & 1
 * 3. 获取 x 的第 n 位的幂值:x & (1 << (n -1))
 * 4. 仅将第 n 位置为 1:x | (1 << n)
 * 5. 仅将第 n 位置为 0:x & (~ (1 << n))
 * 6. 将 x 最高位至第 n 位(含)清零:x & ((1 << n) - 1)
 * 7. 将第 n 位至第 0 位(含)清零:x & (~ ((1 << (n + 1)) - 1))
 *
 *
 *
 *
 * 创建人  : 吴绪森
 * 创建时间：2020-05-04
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_190_0316 {

    public static void main(String[] args) {
        LeetCode_190_0316 reverseBits190 = new LeetCode_190_0316();

        //LeetCode_190_0316.reverseBits(   964176192);


        System.out.println(0 << 1);
    }

    /**
     *  用ans 来保存移位的值，比如 第一位 ，ans需要左移一位，加上n&1,与运算得到的最后一位，
     *  n 右移一位，保持最后一位是需要下次循环获得的值
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0;i < 32;i++){
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans >>> 0;
    }
    public int reverseBits1(int n) {
      int ans = 0;
        for (int i = 0; i < 32; i++) {
             ans = (ans << 1) + (n&1);
             n>>=1;

        }
        return ans;
    }

}
