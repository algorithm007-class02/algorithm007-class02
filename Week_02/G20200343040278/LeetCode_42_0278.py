#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#

# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        n = len(height)

        left, right = 0, n - 1
        maxleft, maxright = height[0], height[n - 1]
        ans = 0

        while left <= right:
            maxleft = max(height[left], maxleft)
            maxright = max(height[right], maxright)
            if maxleft < maxright:
                ans += maxleft - height[left]
                left += 1
            else:
                ans += maxright - height[right]
                right -= 1
        
        return ans
            
            

# 题解1：暴力
# 遍历每个下标，找左边和右边最高的柱子从而判断是否可以接到水
# 题解2：动态规划
# 在1的基础上使用两个数组来表示下标i左右两边最高柱子的高度，一次遍历完成
# 题解3：双指针
# 两个下标，分别位于输入数组的两端，向中间移动，边移动边计算
# maxleft作为0...left的最大值，maxright作为right...结尾的最大值 

# 初见思路1：
# 考虑用一个stack
# 首先进栈一个不为0的元素，然后逐个进栈，直到出现第一个不小于栈底元素的。。元素
# 面积结算是在出现大于栈底元素的情况下，因为可能遍历结束后也不存在比栈底元素大的情况，所以期间需要统计一个次高值。
# 如果出现不小于栈底元素的元素，保存这个值，然后进行面积结算，结算完毕后将这个元素进栈，作为栈底元素。
# 没写完，待继续考虑


# @lc code=end

