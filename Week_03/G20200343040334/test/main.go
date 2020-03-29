package main

import (
	"fmt"
	"strings"
)

func main() {
	// 士兵根据成绩分子单，如果成绩高，相邻的必须多
	// 1,2,2= 1,2,1   2,1,2=2,1,2
	str := ""
	fmt.Scan(&str)
	nums := strings.Split(str, ",")
	subMap := make(map[int]int, len(nums))
	n := 1
	//if nums[0] > nums[1]{
	//	subMap[0] = n+1
	//}else {
	//	subMap[0] = n
	//}
	min := 0
	max := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			subMap[i] += subMap[i-1]+n
			if min >1{
				for index:=0; index<min; index++  {
					subMap[i-min+index-1] = min-index+1
				}
			}
			if max >0{
				subMap[i-1] = n+1
			}
			min = 0
		}else if nums[i] < nums[i-1]{
			min ++
			subMap[i] = n
		}else {
			min = 0
			max++
			subMap[i] = n
		}
		if i == len(nums)-1{
			if nums[i] > nums[i-1]{
				if subMap[i] < subMap[i-1]{
					subMap[i]++
				}
			}else if nums[i] == nums[i-1]{
				subMap[i] = n
			}else {
				if max >0{
					subMap[i-1] = n+1
					max = 0
				}
			}
			if min >1{
				for index:=0; index<=min; index++  {
					subMap[i-min+index] = min-index+1
				}
			}
			break
		}
	}
	sum := 0
	for _, v := range subMap{
		sum += v
	}
	fmt.Println(subMap)
	fmt.Println(sum)
}
