"""
    备注，这个题目完全没思路，自己稿纸上画了一下
"""

class Solution:
    def moveZeroes(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # i 值始终指向第一个为零的位置，遍历数组找到不是0的就和i指向的元素换位置
        i=0
        for j in range(len(l1)):
            if nums[j] != 0:
                nums[i]=nums[j]
                if i != j:
                    nums[j]=0
                i=i+1
        print(l1)

if __name__ == "__main__":
    solution=Solution()
    l1=[0,1,0,3,12,4,0,0,3]
    solution.moveZeroes(l1)

"""
    思路：
        1、 扫描每一个元素，如果是0就append到末尾去，当前位置元素删除
"""