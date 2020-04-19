package main

import "fmt"

func main() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}

func threeSum(nums []int) [][]int {
	if len(nums) < 3 { return [][]int{} }

	QuickSort(nums) // 快排 O(n log n), 本地修改

	ret := make([][]int, 0, 0)
	for i := 0; i < len(nums) - 1; i++ {
		l, r := i + 1, len(nums) - 1

		if nums[i] > 0 || nums[i] + nums[l] > 0 { break }	// 优化掉不可能的情况

		if i > 0 && nums[i] == nums[i-1] { continue }	// i 去重

		for l < r {
			if l > i + 1 && nums[l] == nums[l-1] {	// l 去重
				l++; continue
			}
			if r < len(nums) - 2 && nums[r] == nums[r+1] {	// r 去重
				r--; continue
			}

			if nums[i] + nums[l] + nums[r] > 0 {	//
				r--
			} else if nums[i] + nums[l] + nums[r] < 0 {
				l++
			} else {
				ret = append(ret, []int{nums[i], nums[l], nums[r]})
				l++; r--
			}
		}
	}

	return ret
}

func QuickSort(array []int) {
	if len(array) < 2 { return }

	pivot := array[0]
	l, r := 0, len(array) - 1

	for i := 1; i <= r; {
		if array[i] < pivot { //
			array[l], array[i] = array[i], array[l]
			l++; i++
		} else {
			array[r], array[i] = array[i], array[r]
			r--
		}
	}

	QuickSort(array[:l])
	QuickSort(array[l + 1:])
}
