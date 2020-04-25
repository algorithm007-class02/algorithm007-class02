# 1. 暴力法
#       遍历每根柱子，查找left bound, right bound, 边界为比当前柱子高度高最多的柱子
#       雨水量 = max(min(leftBound, rightBound) - current, 0)
#       [0] = min(0, 1) - 0 = 0
#       [1] = min(0, 2) - 1 = 0
#       [2] = min(1, 2) - 0 = 1
#       [3] = min(0, 3) - 2 = 0
#       [4] = min(2, 3) - 1 = 1
#       [5] = min(2, 3) - 0 = 2
#       [6] = min(2, 3) - 1 = 1
#       [7] = min(0, 0) - 3 = 0
#       [8] = min(3, 2) - 2 = 0
#       [9] = min(2, 2) - 1 = 1
#       [10] = min(3, 0) - 2 = 0
#       [11] = min(2, 0) - 1 = 0
#       
# 2. 动态规划
#       事先遍历保存左右边界，最后一趟遍历计算积水
#       保存左右边界时使用动态规划:
#         Left[i] = max(Left[i-1], height[i-1])
#         Right[i] = max(Right[i+1], height[i+1])
# 3. 栈
# 
# 4. 双指针
# 
# 
class Solution:
    def trap(self, height: List[int]) -> int:
        # 1. 暴力法
        # size = len(height)
        # total = 0
        # for i in range(1, size-1):
        #     leftBound = 0
        #     rightBound = 0
        #     for j in range(i-1, -1, -1):
        #         if height[i] < height[j] and leftBound < height[j]:
        #             leftBound = height[j]
        #     for j in range(i+1, size):
        #         if height[i] < height[j] and rightBound < height[j]:
        #             rightBound = height[j]
        #     area = min(leftBound, rightBound) - height[i]
        #     area = max(area, 0)
        #     total += area
        # return total

        # 2. 动态规划
        # total = 0
        # size = len(height)
        # left = [0]*size
        # right = [0]*size
        # for i in range(1, size):
        #     left[i] = max(left[i-1], height[i-1])
        # for i in range(size-2, -1, -1):
        #     right[i] = max(right[i+1], height[i+1])
        # for i in range(size):
        #     area = max(min(left[i], right[i]) - height[i], 0)
        #     total += area
        # return total

        # 3. 栈
        # total = 0
        # size = len(height)
        # if size <= 2:
        #     return 0
        # stack = []
        # stack.append(0)
        # stack.append(1)
        # for i in range(2, size):
        #     while stack and height[i] > height[stack[-1]]:
        #         # 存在积水，进行计算
        #         curr = stack.pop()
        #         if stack:
        #             heigh = min(height[stack[-1]], height[i]) - height[curr]
        #             width = i - stack[-1] - 1
        #             area = heigh * width
        #             total += max(area, 0)
        #     stack.append(i)
        # return total

        # 4. 双指针
        total = 0
        left = 0
        right = len(height) - 1
        leftBound = rightBound = 0
        while left  <= right:
            leftBound = max(leftBound, height[left])
            rightBound = max(rightBound, height[right])
            if leftBound <= rightBound:
                total += leftBound - height[left]
                left +=1 
            else:
                total += rightBound - height[right]
                right -= 1
        return total