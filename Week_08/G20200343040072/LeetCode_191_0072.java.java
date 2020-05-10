/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
     //1.循环for loop去判断
        // int counts = 0;
        // int bits =1;
   
        // for(int i= 0; i<32 ;i++) {
        //     if((n & bits) != 0 ) {
        //         counts++;
        //     }
        //     bits <<= 1;
        // }
        // return counts;

    //2.先%2，看最后一位是否是零，再/2去掉，相当于把最后一位打掉
        // int counts = 0;
        // for(int i= 0; i<32 ;i++) {
        //     if(n%2 != 0) {
        //         ++counts;
        //     }
        //     n >>= 1;
        // }
        // return counts;
        
    //3.取x&x-1打掉最低位的1
        int counts = 0;
        while(n != 0 ) {
            counts++;
            n &= n-1;
        }
        return counts;

    }
}
// @lc code=end

