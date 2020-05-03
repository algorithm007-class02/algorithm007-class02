//暴力法 当余数为0，说明为偶数，在偶数里一直除2，当最后n==1时说明为2的幂数.计算超时
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        while(n % 2 == 0){
            n = n / 2;
        }
        return n == 1;
    }
}
//若为2的n次幂，n-1后，所有位都会取反。因此n & (n - 1)) == 0
class Solution {
    public boolean isPowerOfTwo(int n) {
        return  ((n > 0) && (n & (n - 1)) == 0);
    }
}
