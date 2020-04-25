"""
    
"""

class Solution:
    """
        思路1 算法
    """
    def maxArea(self, nums) -> int:
        currentmaxarea=[0,0,0]
        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                tmparea=(j-i) * min(nums[i],nums[j])
                if tmparea > currentmaxarea[2]:
                    currentmaxarea[0]=i
                    currentmaxarea[1]=j
                    currentmaxarea[2]=tmparea
        return currentmaxarea
    
    """
        思路2 算法 这个运行不成功，还要在调试一下，打算后面再按照老师的思路实现以下
    """
    def maxArea2(self, height) -> int:
        currentmaxarea=0
        x=0
        y=len(height)-1
        while x<y:
            tmparea=(y-x) * min(height[x],height[y])
            if tmparea>=currentmaxarea:
                currentmaxarea=tmparea
            if height[x+1] <= height[y-1]:
                x=x+1
            else:
                y=y-1
        return currentmaxarea


if __name__ == "__main__":
    solution=Solution()
    l1=[1,8,6,2,5,4,8,3,7]
    
    #l1=[1,2]
    #l1=[1,1]
    #l1=[1,3,2,5,25,24,5]
    print(solution.maxArea(l1))
    print(solution.maxArea2(l1))

"""
    思路：
        1、 遍历所有可能的组合，生成数组排序
        2、 老师提示，，左右边界自己实现
"""