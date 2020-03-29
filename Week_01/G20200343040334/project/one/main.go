package main

import "fmt"

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
// 26. 删除排序数组中的重复项
//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//
//
// 示例 1:
//
// 给定数组 nums = [1,1,2],
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//你不需要考虑数组中超出新长度后面的元素。
//
// 示例 2:
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
//
//
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
// Related Topics 数组 双指针


func main() {
	nums := []int{1,3,34,34,45,45,45}
	removeDuplicates(nums)
	removeDuplicates2(nums)
}

/**
	left right指针作比较，将相等的移到右侧 d
 */
func removeDuplicates(nums []int) int {
	left, right := 0, 1
	for ; right < len(nums); right++ {
		if nums[left] == nums[right] {
			continue
		}
		left ++
		nums[left] = nums[right]
	}
	return left+1
}

/**
	数组覆盖值
 */
func removeDuplicates2(nums []int) int {
	for i:=len(nums)-1; i>0; i-- {
		if nums[i] == nums[i-1] {
			nums = append(nums[:i], nums[i+1:]...)
			fmt.Println(nums)
		}
	}
	return len(nums)
}
