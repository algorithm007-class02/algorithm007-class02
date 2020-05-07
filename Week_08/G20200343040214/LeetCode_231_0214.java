class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        int temp = n & (n - 1);
        return temp == 0;
    }
}