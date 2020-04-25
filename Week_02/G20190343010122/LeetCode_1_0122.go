package homework


func twoSum(nums[]int, target int)[]int{
	expectMap := make(map[int]int, 0)  // 存放期待值的map
	expectMap[nums[0]] = 0
	result := make([]int, 0)
	for i:=1; i<len(nums);i++{
		expectValue := target - nums[i]
		index, ok := expectMap[expectValue]
		if ok{
			result = append(result, index)
			result = append(result, i)
			return result
		}
		expectMap[nums[i]] = i
	}

	return result
}
