public class LeetCode_190_0222 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (((n >> i) & 1) << (31 - i));
        }
        return res;
    }

    public int reverseBitsRe(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }
}