func permuteUnique(nums []int) [][]int {
    ret := make([][]int, 0)
    backtrack(nums, 0, &ret)
	return ret
}

func backtrack(nums []int, first int, ret *[][]int) {
	if len(nums) == first {
		*ret = append(*ret, append([]int(nil), nums...))
	}

	used := map[int]bool{}
	for i := first; i < len(nums); i++ {
		if used[nums[i]] {
			continue
		}
		used[nums[i]] = true
		nums[i], nums[first] = nums[first], nums[i]
		backtrack(nums, first+1, ret)
		nums[i], nums[first] = nums[first], nums[i]
	}
}
