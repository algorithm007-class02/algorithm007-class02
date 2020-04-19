# 二分查找法
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        left = 0
        right = len(matrix) - 1
        head_list = [x[0] for x in matrix]
        while left < right:
            mid = left + (right - left) // 2
            if head_list[mid] == target:
                return True
            if head_list[mid] > target:
                right = mid
            else:
                if head_list[mid+1] == target:
                    return True
                if head_list[mid+1] > target:
                    right = left = mid
                else:
                    left = mid + 1
        l = left
        left = 0
        right = len(matrix[l])-1
        while left < right:
            mid = left + (right - left) // 2
            if matrix[l][mid] == target:
                return True
            if matrix[l][mid] > target:
                right = mid
            else:
                left = mid + 1
        return False if matrix[l][left]!=target else True