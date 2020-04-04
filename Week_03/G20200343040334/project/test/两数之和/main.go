package main

import "fmt"

func main() {
	fmt.Println(twoSum([]int{1,2,4,3,4,4}, 7))
}

func twoSum(nums []int, target int) (res []int) {
	submap := map[int]int{}
	for index, n := range nums {
		if v, ok := submap[target-n]; ok {
			res = append(res, v, index)
			return res
		}
		submap[n] = index
	}
	return res
}
