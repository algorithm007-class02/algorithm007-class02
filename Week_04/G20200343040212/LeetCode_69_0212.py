# 实现 int sqrt(int x) 函数。 
# 
#  计算并返回 x 的平方根，其中 x 是非负整数。 
# 
#  由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
# 
#  示例 1: 
# 
#  输入: 4
# 输出: 2
#  
# 
#  示例 2: 
# 
#  输入: 8
# 输出: 2
# 说明: 8 的平方根是 2.82842..., 
#      由于返回类型是整数，小数部分将被舍去。
#  
#  Related Topics 数学 二分查找


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mySqrt(self, x: int) -> int:

        # 二分查找法
        # if x < 2:
        #     return x
        # left, right = 2, x // 2
        # mid = 0
        # while left <= right:
        #     mid = left + (right - left) // 2
        #     if mid * mid > x:
        #         right = mid - 1
        #     elif mid * mid < x:
        #         left = mid + 1
        #     else:
        #         return mid
        # return right

        # 牛顿迭代法
        r = x
        while r * r > x:
            r = (r + x // r) // 2
        return r

# leetcode submit region end(Prohibit modification and deletion)
