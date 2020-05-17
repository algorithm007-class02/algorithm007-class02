//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找

/*面试考点
* 1.能否实现logn复杂度的算法
* 2.能否考虑到所有特殊测试数据
*
* 任何数的0次方都是1,0的1次方是0，*/


//leetcode submit region begin(Prohibit modification and deletion)
class Solution50 {
    /*迭代练手*/
    public double myPowHelper (double x, long N){
        if (N==0) {return 1.0;}

        double y = myPowHelper(x, N/2);
        return N%2==0 ? y*y : y*y*x;
    }
    public double myPow(double x, int n){
        long N = n;
        return N>=0 ? myPowHelper(x,N): 1.0/myPowHelper(x, -N);
    }
    /*时间和空间复杂度都是O(logn)
     * 耗时1ms（95%），使用内存36.9M（6%）*/
}
//leetcode submit region end(Prohibit modification and deletion)

/*迭代---优化至O(logn)，二分法是最常见的logn算法
 * */
//    public double myPowHelper(double x, long N){
//        //递归出口，任何数的0次方都是1
//        if (N==0) {return 1.0;}
//
//        //分治，奇偶性不同时有不同的公式
//        //偶数次幂，y=x^(n/2),y*y=x^n;
//        //奇数次幂，y=x^(n/2),y*y*x=x^n;
//        double y = myPowHelper(x,N/2);
//        return N%2==0 ? y*y: y*y*x;
//    }
//    public double myPow(double x, int n){
//        //java中int类型的范围n∈[−2147483648,2147483647]，如果n=−2147483648，执行-n就会出现越界，所以转为long来操作就安全了。
//        long N = n;
//        return N>=0 ? myPowHelper(x,N): 1.0/myPowHelper(x,-N);  //注意-N
//    }
    /*时间和空间复杂度都是O(logn)
     * 耗时1ms（95%），使用内存37.2M（6%）*/

/*暴力法*/
//    public double myPow(double x, int n) {
//        //java中int类型的范围n∈[−2147483648,2147483647]，如果n=−2147483648，执行-n就会出现越界，所以转为long来操作就安全了。
//        double ans=1;
//        long N = n;
//        //处理指数为负的情况
//        if (N<0){
//            x=1/x;
//            N=-N;
//        }
//        for (long i=0; i<N; i++){
//            ans=ans*x;
//        }
//        return ans;
//    }
/*超时,时间复杂度O(n)，空间复杂度O(1)*/
