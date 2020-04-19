//递归法
class Solution {
public:
    double myPow(double x, int n) {
        if(n<0){
            return (1/x)*myPow(1/x,-(n+1));
        }
        if(n==0) return 1;
        double ans = myPow(x,n/2);
        return n%2==0?ans*ans:ans*ans*x;
    }
};

//迭代法:快速幂

 
