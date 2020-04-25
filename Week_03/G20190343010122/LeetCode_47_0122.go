package HomeWork

var result [][]int

func permuteUnique(nums []int) [][]int {
	if nums == nil || len(nums) == 0{
		return result
	}

	result = [][]int{}
	ans := []int{}
	backTrack(nums, ans)
	return result
}

func backTrack(nums []int, ans[]int){
	if len (nums) == 0{
		copyAns := make([]int, 0)
		copyAns = append(copyAns, ans...)
		result = append(result, copyAns)
	}

	uniqueMap := make(map[int]int, 0)
	for i:=0; i<len(nums); i++ {
		// 选择
		_,ok := uniqueMap[nums[i]]
		if ok{
			continue
		}else{
			uniqueMap[nums[i]] = 0
		}
		val := nums[i]
		ans = append(ans, val)
		nums = append(nums[:i],nums[i+1:]...)
		backTrack(nums, ans)

		// 回滚选择
		ans = ans[:len(ans)-1]
		nums = append(nums[:i], append(append([]int{val}), nums[i:]...)...)
	}
}
