package g20200343040032

func moveZeroes(nums []int) {
	i := 0
	l := len(nums)

	for _, v := range nums {
		if v != 0 {
			nums[i] = v
			i++
		}
	}

	for j := i; j < l; j++ {
		nums[j] = 0
	}
}
