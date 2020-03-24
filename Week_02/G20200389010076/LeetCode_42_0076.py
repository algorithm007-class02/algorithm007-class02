class Solution:
    def trap(self, height: List[int]) -> int:
        #栈
        #遍历所有的墙，如果栈为空，墙下标入栈
        #1.如果当前指向的墙比栈顶的墙矮入栈
        #2.否则出栈，计算当前指向的墙与新栈顶哪个矮，
        #矮的墙的高度减去刚刚出栈的墙的高度在乘两高墙之间的距离，重复一二
        stack=[]
        trap=0
        for current in range(len(height)):
            while stack!=[] and height[stack[-1]]<height[current]:
                middle=height[stack.pop()]
                if stack==[]:
                    break
                min_side=min(height[current],height[stack[-1]])
                trap+=(min_side-middle)*(current-stack[-1]-1)
            stack.append(current)
        return trap