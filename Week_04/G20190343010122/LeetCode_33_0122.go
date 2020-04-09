package homework


func search(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	for left <= right {

		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		}

		if nums[mid] < nums[right] { // 右边升序
			if nums[mid] < target && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		} else {
			if nums[mid] > target && target >= nums[left] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		}
	}

	return -1
}
