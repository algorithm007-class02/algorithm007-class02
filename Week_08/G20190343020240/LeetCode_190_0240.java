class Solution {
    // you need treat n as an unsigned value
    //颠倒二进制
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 31; n != 0; n = n >>> 1,i--){
            int cur = n & 1;
            res += cur << i;
        }
        return res;
    }
}