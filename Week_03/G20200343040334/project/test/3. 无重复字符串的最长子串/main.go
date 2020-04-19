package main

import "fmt"

func main() {
	fmt.Println(lengthOfLongestSubstring("pwwkewq"))
}

func lengthOfLongestSubstring(s string) int {
	// 1.记录最大长度遍历整个数组，申请一个数组最大值为500，判断数组的值大于当前开始的下标，否则赋值数组
	max := func(a,b int) int {
		if a > b {return a}
		return b
	}
	begin, maxNum := 0, 0
	var nums [500]int
	for i, v := range s {
		if nums[v] > 0 && nums[v] > begin {
			begin = nums[v]
		}
		maxNum = max(maxNum, i-begin+1)
		nums[v] = i+1
	}
	return maxNum
}