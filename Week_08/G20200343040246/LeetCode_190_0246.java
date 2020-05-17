package Week_08.G20200343040246;

public class LeetCode_190_0246 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_190_0246().reverseBits(12));
    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }
}