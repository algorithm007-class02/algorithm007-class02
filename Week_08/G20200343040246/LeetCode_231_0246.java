package Week_08.G20200343040246;

public class LeetCode_231_0246 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_231_0246().isPowerOfTwo(16));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }
}