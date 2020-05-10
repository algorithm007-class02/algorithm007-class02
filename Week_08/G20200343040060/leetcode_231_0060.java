public class PowerOfTwo_231 {
    public static void main(String[] args) {
        int i=16;
        boolean res= isPowerOfTwo(i);
        System.out.println(res);
    }


    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
