func twoSum(nums []int, target int) []int {
	mapdata := map[int]int{}
	for index, val := range nums {
		data := target - val
		if j, ok := mapdata[data]; ok {
			return []int{index, j}
		}
		mapdata[val] = index
	}
	return []int{}
}
