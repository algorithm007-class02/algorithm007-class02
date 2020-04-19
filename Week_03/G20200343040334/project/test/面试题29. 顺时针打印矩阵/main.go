package main

import "fmt"
// https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/golang-mo-ni-shun-shi-zhen-lu-jing-by-sakura-151/
func main() {
	matrix := [][]int{{1,2,3},{4,5,6},{7,8,9}}
	fmt.Println(spiralOrder(matrix))
}

func spiralOrder(matrix [][]int) []int {
	size := len(matrix) * len(matrix[0])
	step := 0
	top, bottom, left, right, res := 0, len(matrix)-1, 0, len(matrix[0])-1, make([]int, size)
	for step < size {
		// 从左到右
		for i:=left; i<= right;i++ {
		//for i:=left; i<= right && step < size;i++ {
			res[step] = matrix[top][i]
			step++
		}
		top++
		// 从上到下
		for i:= top; i<= bottom; i++{
		//for i:= top; i<= bottom && step < size; i++{
			res[step] = matrix[i][right]
			step++
		}
		right--
		// 从右到左
		for i:= right; i>= left; i-- {
		//for i:= right; i>= left && step < size; i-- {
			res[step] = matrix[bottom][i]
			step++
		}
		bottom--
		// 从下到上
		for i:= bottom; i>= top; i--  {
		//for i:= bottom; i>= top && step < size; i--  {
			res[step] = matrix[i][left]
			step++
		}
		left++
	}
	return res
}
