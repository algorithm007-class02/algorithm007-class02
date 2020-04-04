/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
// 1.二分查找
class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long left = 1, right = x, mid = 1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(mid * mid > x){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}

// 2.牛顿迭代法
class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
// @lc code=end

