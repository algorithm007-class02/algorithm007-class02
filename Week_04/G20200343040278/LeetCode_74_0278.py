#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] 搜索二维矩阵
#

# @lc code=start
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix: 
            return False
        row = len(matrix)
        col = len(matrix[0])
        left = 0
        right = row * col
        while left < right:
            mid = left + (right - left) // 2
            if matrix[mid // col][mid % col] == target:
                return True
            elif matrix[mid // col][mid % col] < target:
                left = mid + 1
            else:
                right = mid
        return False

# 初见思路1：二分查找 * 2，第一遍定位可能不准
# 初见思路2：转成一维然后二分
# 初见思路3：库函数  

# @lc code=end

