package level2;

public class Solution50 {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        double y = x;
        if (n == 0)
            return 1;
        if (n < 0) {
            y = 1 / x;
            // 极限条件
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE - 1;
            } else {
                n = -n;
            }
        }
        double half = myPow(y, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * y;
        }
    }
}
