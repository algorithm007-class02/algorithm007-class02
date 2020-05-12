class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        long x = n & 0x0FFFFFFFFl;
        while (x > 0) {
            if (x % 2 == 1) {
                num++;
            }
            x = x / 2;
        }
        return num;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}