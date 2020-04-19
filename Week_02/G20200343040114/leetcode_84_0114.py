# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
# 求在该柱状图中，能够勾勒出来的矩形的最大面积。

class Solution:
    # 每根柱子能够往两边扩展的最大面积
    def largestRectangleArea(self, heights: List[int]) -> int:
        i = 0
        stack = []
        n = len(heights)
        ans = 0
        if n == 0:
            return 0
        while i < n:
            while len(stack) != 0 and heights[i] < heights[stack[-1]]:
                top = stack.pop()
                if len(stack) == 0:
                    left = -1
                else:
                    left = stack[-1]
                print(f'top: {top} left: {left} i: {i}')
                ans = max(heights[top]*(i - left - 1), ans)
            stack.append(i)
            i += 1

        # [0, 2], [1, 2, 3], [1, 1] 这些
        while len(stack) != 0:
            top = stack.pop()
            if len(stack) == 0:
                left = -1
            else:
                left = stack[-1]
            print(f'top: {top} left: {left} i: {i}')
            ans = max(heights[top]*(i - left - 1), ans)
        return ans