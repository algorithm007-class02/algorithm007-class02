package main

import "fmt"

func main() {
	arr := []int{2,1,5,6,2,3}
	//arr := []int{1,2,45,3,56,32,42,3,1}
	result := largestRectangleArea(arr)
	//result := largestRectangleAreatest(arr)
	fmt.Println("result = ", result)
}

// 1.暴力（根据宽找高度）：
// 两个柱子之间的最大矩形，由最矮柱子决定，所以在两个指针的遍历中找到最矮柱子
// 2.分治：最矮柱子的矩形宽可以无限延伸。找到左右边界范围内的最矮柱子，求以它为高的矩形、其左、右柱子中（子问题）矩形最大面积的最大值。
// 3.优化分治：用线段树代替遍历找到最矮柱子。
// 4.升序栈（根据高度找宽）：对于每个高度来说，往左右两个方向寻找第一个比它矮的柱子，决定矩形的宽。
// 所以用高度升序栈保存索引，遇到减小的，表示找到右边界。计算这中间每个柱子的最大矩形，计算一个即出栈，这样方便每次从栈顶取索引。
// 时间复杂度：O(n)， n个数字每个会被压栈弹栈各一次。
// 空间复杂度：O(n)。用来存放栈中元素。

// 首尾添加负数高度，这样原本的第一个高度能形成升序，原本的最后一个高度也能得到处理
func largestRectangleArea(heights []int) int{
	heights = append([]int{-2}, heights...)
	heights = append(heights, -1)
	length := len(heights)
	stack := make([]int, 1, length)
	maxRes := 0
	i := 1
	for i < length{
		if heights[stack[len(stack)-1]] < heights[i]{
			stack = append(stack, i)
			i++
			fmt.Println(i," append stack : ", stack)
			continue
		}
		fmt.Println(i," first stack : ", stack)
		maxRes = max(maxRes, heights[stack[len(stack)-1]] * (i-stack[len(stack)-2]-1))
		fmt.Println("maxRes : ", maxRes, " i : ", i)
		fmt.Println("old stack : ", stack)
		stack = stack[:(len(stack)-1)]
		fmt.Println("end stack : ", stack)
	}
	return maxRes
}

func max(a, b int) int {
	if a > b {return a}
	return b
}
