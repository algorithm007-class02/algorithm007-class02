package com.yequan.leetcode.bit.reverseBits_190;

/**
 * @author : Administrator
 * @date : 2020/5/3
 */
public class ReverseBits {

    /**
     * 从低位按位反转 i => 31-i
     * 每次取n最低位, 然后n每次右移一位
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        for (int bit = 31; n != 0; bit--) {
            ans += (n & 1) << bit;
            n = n >>> 1;
        }
        return ans;
    }

}
