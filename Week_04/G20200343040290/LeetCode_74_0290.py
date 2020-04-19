class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        m = len(matrix)
        n = len(matrix[0])
        nums = m*n
        if not nums:
            return False

        left,right = 0,nums-1
        def turn_num_to_axis(num):
            return ([num//n,num%n])
        while left <right:
            mid_num = (left+right)//2
            mid = turn_num_to_axis(mid_num)
            if matrix[mid[0]][mid[1]] == target:
                return True
            elif target > matrix[mid[0]][mid[1]]:
                left = mid_num + 1
            else:
                right = mid_num - 1
        mid = turn_num_to_axis(left)
        return True if left == right and matrix[mid[0]][mid[1]] == target else False
