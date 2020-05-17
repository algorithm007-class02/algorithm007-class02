/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    //1.逐个取出n最右的位，并根据当前最右计算出颠倒后的位置，
    // 和一个初始为0 的数逐步相加
    // 复杂度分析
    // 时间复杂度：O(log⁡2N)\mathcal{O}(\log_2{N})O(log2​N)。在算法中，我们有一个循环来迭代输入的最高非零位，即log⁡2N\log_2{N}log2​N。
    // 空间复杂度：O(1)\mathcal{O}(1)O(1)，因为不管输入是什么，内存的消耗是固定的。

        // int res =0;
        // int power =31;
        // while(power >= 0) {
        //     res +=(n & 1) << power;
        //     power -= 1;
        //     n >>= 1;
        // }
        // return res;

    //2.逐个取出你的最右位，以或的形式去重置res的最末尾
        // int res =0;
        // for (int i = 0; i < 32; i++) {
        //     res <<= 1;
        //     res |= (n & 1);
        //     n >>= 1;
        // }
        // return res;

      //国际站方法  
        if (n == 0) return 0;
            
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
                n >>= 1;
            }
        return result;
        
    }
}
// @lc code=end

