package G20200343040028


func rotate(nums []int, k int) {
	if k == 0 {
		return
	}
	length := len(nums)
	for i := 0; i < k; i++ {
		tmp := nums[length-1]
		for j := length - 1; j > 0; j-- {
			nums[j] = nums[j-1]
		}
		nums[0] = tmp
	}
}
