package main

import "fmt"

func main() {
	fmt.Println(maxArea([]int{1,8,6,2,5,4,8,3,7}))
}

func maxArea(height []int) int {
	l, r := 0, len(height)-1
	maxArea := 0
	min := func(a, b int) int {
		if a > b {
			return b
		}
		return a
	}
	max := func(a, b int) int {
		if a < b {
			return b
		}
		return a
	}
	for l != r {
		maxArea = max(maxArea, min(height[l], height[r])*(r-l))
		if height[l] > height[r] {
			r--
		} else {
			l++
		}
	}
	return maxArea

}
