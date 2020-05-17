public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 1. 依次获取n的最后一位 n&1. n = n >> 1;
        // 2.新建int 加上n的最后一位后，左移
        int res = 0;
        for (int i = 0; i < 32; i++){
            int a= n&1;
            n = n>>1;
            res = (res << 1) + a;            
        }
        return res;
    }
}