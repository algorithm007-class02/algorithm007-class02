# -*- coding:utf-8 -*-


class Solution:
    def maxArea(self, height) -> int:
        len_h = len(height)
        if len_h < 2:
            return 0
        max_area = min(height[0], height[-1]) * (len_h - 1)
        i, j = 0, len_h - 1
        while i < j:
            max_area = max(max_area, min(height[i], height[j]) * (j - i))
            if height[i] <= height[j]:
                i += 1
            else:
                j -= 1

        return max_area
