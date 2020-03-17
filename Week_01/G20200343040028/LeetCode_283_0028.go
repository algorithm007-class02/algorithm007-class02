package G20200343040028


func moveZeroes(nums []int) {
	k := 0
	length := len(nums)
	for i := 0; i < length; i++ {
		if nums[i] != 0 {
			nums[k], nums[i] = nums[i], nums[k]
			k++
			length--
		}
	}
}