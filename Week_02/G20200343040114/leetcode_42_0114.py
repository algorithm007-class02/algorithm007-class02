
# 每个坑里面的水往两边扩展的最大宽度
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        i = 0
        ans = 0
        while i < len(height):
            while len(stack) != 0 and height[i] > height[stack[-1]]:
                top = stack.pop()
                if len(stack) == 0:
                    break
                left = stack[-1]
                print(f'left: {left}, top: {top}')
                area = (min(height[i], height[left]) -
                        height[top]) * (i - left - 1)
                ans += area
            stack.append(i)
            i += 1
        return ans
