class Solution:
    def trap(self, height: List[int]) -> int:
        cal_start,cal_end = 0,len(height)-1
        max_left,max_right = 0,0
        cub = 0

        while cal_start < cal_end:
            max_left = max(max_left,height[cal_start])
            max_right = max(max_right,height[cal_end])
            if max_left > max_right:
                cub += (height[cal_end]-max_right)
                cal_end -= 1
            else:
                cub += height[cal_start] -max_left
                cal_start += 1
        return cub
            
        
