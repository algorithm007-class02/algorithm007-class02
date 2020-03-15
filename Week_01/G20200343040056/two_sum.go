func twoSum(nums []int, target int) []int {
    temSet := make(map[int]int)
	for i, x := range nums {
		temSet[x] = i
	}
	for i, x := range nums {
        if v, ok := temSet[x]; ok && v == i {
            delete(temSet, x)
        }
		y := target - x
		if j, ok := temSet[y]; ok {
			return []int{i, j}
		}
	}
	return []int{}
}