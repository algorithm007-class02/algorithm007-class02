//classical division problem
/*
pow (x, n):
    subproblem: subresult = pow (x, n / 2)

merge:
    if n % 2 == 1 {
        //odd
        result = result * result * x;
    } else {
        //even
        result = result * result;
    }
*/
//采用分治法，O(logn) O(logn)
class Solution {
public:
    double fastPow(double x, long long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    double myPow(double x, int n) {
        long long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
};