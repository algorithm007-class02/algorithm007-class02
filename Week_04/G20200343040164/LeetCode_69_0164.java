//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sqr = mid * mid;
            long nextSqr = (mid + 1) * (mid + 1);
            if (sqr <= x && nextSqr > x)
                return (int) mid;
            else if (sqr > x)
                right = mid - 1;
            else if (sqr < x)
                left = mid + 1;
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 *      public int mySqrt(int x) {
 *         if (x < 2) return x;
 *         long left = 1;
 *         long right = x / 2;
 *         while (left < right) {
 *             long mid = (right + left) / 2 + 1;
 *             if (mid > x / mid) {
 *                 right = mid - 1;
 *             }else left = mid;
 *         }
 *         return (int) left;
 *     }
 */
