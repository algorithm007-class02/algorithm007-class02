func twoSum(nums []int, target int) []int {
	temSet := make(map[int]int)
	for i, x := range nums {
		y := target - x
		if j, ok := temSet[y]; ok {
			return []int{i, j}
		}
		temSet[x] = i
	}
	return []int{}
}