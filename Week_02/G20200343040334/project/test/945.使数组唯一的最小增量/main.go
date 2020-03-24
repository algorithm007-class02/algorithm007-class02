package main

import (
	"fmt"
	"sort"
)

func main() {
	arr := []int{3,2,1,2,1,7}
	fmt.Println(minIncrementForUnique1(arr))
	fmt.Println(minIncrementForUnique(arr))
}

func minIncrementForUnique(arr []int) int {
	sort.Ints(arr)
	res, value := 0, arr[0]
	for i := 1; i < len(arr); i++ {
		if arr[i] <= value{
			value ++
			res += value-arr[i]
			arr[i] += value-arr[i]
		}else {
			value = arr[i]
		}
	}
	return res
}

var pos []int
func minIncrementForUnique1(A []int) int {
	pos = make([]int, 8000)
	move := 0
	for _, a := range A{
		b := findPos(a)
		move += b-a
	}
	return move
}

func findPos(a int) int {
	if pos[a] == 0{
		pos[a] = a
		return a
	}
	b := findPos(a+1)
	pos[a]=b
	return b
}
