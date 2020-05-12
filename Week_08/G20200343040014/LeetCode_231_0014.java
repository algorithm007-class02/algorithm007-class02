class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int count = 0;
        for (int i = 0; i < 32; i++){
            if ((n&1) == 1) count ++; 
            n = n>>1;
        }
        return count == 1;//如果是2的指数，那么只可能有一位为1
    }
}