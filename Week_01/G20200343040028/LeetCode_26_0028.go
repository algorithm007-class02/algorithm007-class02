package G20200343040028


func removeDuplicates(nums []int) int {
	switch len(nums) {
	case 0:
		return 0
	case 1:
		return 1
	}

	i := 0
	for j := 1; j < len(nums); j++ {
		if nums[i] != nums[j] {
			if j-i > 1 {
				nums[i+1] = nums[j]
			}
			i++
		}
	}
	return i + 1
}
