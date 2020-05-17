class Solution {

    public int reverseBits(int n) {
        int ans = 0;
        for (int size = 31; n != 0; n = n >>> 1, size--) {
            ans += (n & 1) << size;
        }
        return ans;
    }

}